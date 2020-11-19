package com.amrengp.web.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.amrengp.web.common.IStatusMessage;
import com.amrengp.web.common.utils.ShiroFilterUtils;
import com.amrengp.web.pojo.BaseAdminUser;
import com.amrengp.web.response.ResponseResult;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Deque;


/**
 * @Title: KickouSessionFilter
 * @Description: 进行用户访问控制
 * @author: amrengp
 * @version: 1.0
 * @date: 2018/11/23 9:37
 */
public class KickoutSessionFilter extends AccessControlFilter {

    private static final Logger logger = LoggerFactory.getLogger(KickoutSessionFilter.class);

    private final static ObjectMapper objectMapper = new ObjectMapper();

    private String kickoutUrl; // Address after kicked out
    private boolean kickoutAfter = false; // Kick out users who have logged in before/after logging in. Default false Kick out users who have logged in before
    private int maxSession = 1; // Maximum number of sessions of the same account Default 1
    private SessionManager sessionManager;
    private Cache<String, Deque<Serializable>> cache;

    public void setKickoutUrl(String kickoutUrl) {
        this.kickoutUrl = kickoutUrl;
    }

    public void setKickoutAfter(boolean kickoutAfter) {
        this.kickoutAfter = kickoutAfter;
    }

    public void setMaxSession(int maxSession) {
        this.maxSession = maxSession;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    // Set the prefix of the cache key
    public void setCacheManager(CacheManager cacheManager) {
        //Must be consistent with the cache name in the ehcache cache configuration
        this.cache = cacheManager.getCache("shiro-activeSessionCache");
    }



    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response)throws Exception {
        Subject subject = getSubject(request,response);
        // No login authorization and no remember me
        if(!subject.isAuthenticated() && !subject.isRemembered()){
            // If you are not logged in, proceed directly to the following process
            return true;
        }
        // Get the URI requested by the user
        HttpServletRequest req=(HttpServletRequest) request;
        String path = req.getRequestURI();
        logger.info("===The currently requested uri:" + path);

        if(path.equals("/login")){
            return true;
        }
        Session session = subject.getSession();
        logger.info("session time setting：" + String.valueOf(session.getTimeout()));


        try{
            // Current user
            BaseAdminUser user = (BaseAdminUser) subject.getPrincipal();
            String username = user.getSysUserName();
            logger.info("===Current user username:" + username);
            Serializable sessionId = session.getId();
            logger.info("===Current user sessionId:" + sessionId);
            // Read the cache user and save it if not
            Deque<Serializable> deque = cache.get(username);
            logger.debug("===Current deque:" + deque);
            if (deque == null) {
                // Initialize the queue
                deque = new ArrayDeque<Serializable>();
            }
            // If there is no such sessionId in the queue and the user has not been kicked out; put it in the queue
            if (!deque.contains(sessionId) && session.getAttribute("kickout") == null) {
                // Store sessionId in the queue
                deque.push(sessionId);
                // Cache the user's sessionId queue
                cache.put(username, deque);
            }
            // If the number of sessionIds in the queue exceeds the maximum number of sessions, start kicking people
            while (deque.size() > maxSession) {
                logger.debug("===Deque queue length:" + deque.size());
                Serializable kickoutSessionId = null;
                // Whether to kick out those who log in later, the default is false; that is, the user who logs in in the latter kicks out the user who logs in in the former;
                if (kickoutAfter) { // If you kick the latter
                    kickoutSessionId = deque.removeFirst();
                } else { // Otherwise kick the former
                    kickoutSessionId = deque.removeLast();
                }
                // Update the cache queue after kicking out
                cache.put(username, deque);
                try{
                    // Get the session object of the kicked sessionId
                    Session kickoutSession = sessionManager
                            .getSession(new DefaultSessionKey(kickoutSessionId));
                    if (kickoutSession != null) {
                        // Set the kickout attribute of the session to indicate a kickout
                        kickoutSession.setAttribute("kickout", true);
                    }
                }catch (Exception e){

                }
            }

            // If you are kicked out, (the former or the latter) exit directly and redirect to the kicked address
            if ((Boolean) session.getAttribute("kickout") != null
                    && (Boolean) session.getAttribute("kickout") == true){
                // The conversation was kicked out
                try {
                    // sign out
                    subject.logout();
                } catch (Exception e) { // ignore
                }
                saveRequest(request);
                logger.debug("===The path where the user is redirected after kicking out kickoutUrl:" + kickoutUrl);
                return isAjaxResponse(request,response);
            }
            return true;
        }catch (Exception e){
            logger.error("Control the number of users online【KickoutSessionFilter.onAccessDenied】异常！", e);
            return isAjaxResponse(request,response);
        }
    }


    public static void out(ServletResponse response, ResponseResult result){
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");//Set encoding
            response.setContentType("application/json");//Set the return type
            out = response.getWriter();
            out.println(objectMapper.writeValueAsString(result));//Output
            logger.info("User online limit [KickoutSessionFilter.out] Response to json information successfully");
        } catch (Exception e) {
            logger.error("User online limit [KickoutSessionFilter.out] Error in response to json information", e);
        }finally{
            if(null != out){
                out.flush();
                out.close();
            }
        }
    }

    private boolean isAjaxResponse(ServletRequest request,
                                   ServletResponse response) throws IOException {
        // ajax request
        /**
         * Determine whether it has been kicked
         * 1. If it is Ajax access, give json return value prompt.
         * 2. If it is a normal request, jump directly to the login page
         */
        //Determine if it is an Ajax request
        ResponseResult responseResult = new ResponseResult();
        if (ShiroFilterUtils.isAjax(request) ) {
            logger.info(getClass().getName()+ "The current user has logged in elsewhere and it is an Ajax request!");
            responseResult.setCode(IStatusMessage.SystemStatus.MANY_LOGINS.getCode());
            responseResult.setMessage("You have logged in elsewhere, please change your password or log in again");
            out(response, responseResult);
        }else{
            // Redirect
            WebUtils.issueRedirect(request, response, kickoutUrl);
        }
        return false;
    }


}
