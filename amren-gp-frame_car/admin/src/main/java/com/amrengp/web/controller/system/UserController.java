package com.amrengp.web.controller.system;

import com.amrengp.web.dto.LoginDTO;
import com.amrengp.web.dto.UserSearchDTO;
import com.amrengp.web.pojo.BaseAdminUser;
import com.amrengp.web.response.PageDataResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title: UserController
 * @Description: 系统用户管理
 * @author: amrengp
 * @version: 1.0
 * @date: 2018/11/20 15:17
 */
@Controller
@RequestMapping("user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     *
     * Function description: login system
     *
     * @param:
     * @return:
     */
    @RequestMapping("login")
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest request, LoginDTO loginDTO, HttpSession session){
        logger.info("Login");
        Map<String,Object> data = new HashMap();
        // Login with shiro
        Subject subject = SecurityUtils.getSubject();

        String userName = loginDTO.getUsername().trim();
        String password = loginDTO.getPassword().trim();
        String rememberMe = loginDTO.getRememberMe();
        String host = request.getRemoteAddr();

        //Get token
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password,host);

        // Set the function of remenmberMe
        if (rememberMe != null && rememberMe.equals("on")) {
            token.setRememberMe(true);
        }

        try {
            subject.login(token);
            // login successful
            BaseAdminUser user = (BaseAdminUser) subject.getPrincipal();

            session.setAttribute("user", user.getSysUserName());
            data.put("code",1);
            data.put("url","/home");
            //data.put("message","login successful");
            logger.info(user.getSysUserName()+"login successful");
        } catch (UnknownAccountException e) {
            data.put("code",0);
            data.put("message",userName+"Account does not exist");
            logger.error(userName+"Account does not exist");
            return data;
        }catch (DisabledAccountException e){
            data.put("code",0);
            data.put("message",userName+"Account exception");
            logger.error(userName+"Account exception");
            return data;
        }
        catch (AuthenticationException e){
            data.put("code",0);
            data.put("message",userName+"wrong password");
            logger.error(userName+"wrong password");
            return data;
        }

        return data;
    }

}
