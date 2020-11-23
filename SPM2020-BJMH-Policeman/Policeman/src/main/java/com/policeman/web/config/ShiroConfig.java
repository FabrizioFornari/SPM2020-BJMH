package com.policeman.web.config;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.policeman.web.filter.KickoutSessionFilter;
import com.policeman.web.shiro.MyRealm;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.io.ResourceUtils;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Title: ShiroConfig
 * @Description: shiroConfiguration
 * @version: 1.0
 */
@Configuration
public class ShiroConfig {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 9, ShiroFilterFactoryBean handles intercepting resource file filters
     * </br>1, configure shiro security manager interface securityManage;
     * </br>2, shiro connection constraint configuration filterChainDefinitions;
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

        logger.info("Shiro interceptor factory class injection begins");

        // Configure shiro security manager SecurityManager
        bean.setSecurityManager(securityManager);
        //Add kick out certification
        HashMap<String, Filter> hashMap=new HashMap<String, Filter>();
        hashMap.put("kickout",kickoutSessionFilter());
        bean.setFilters(hashMap);

        // Specify the link when logging in is required
        bean.setLoginUrl("/login");
        // The link to be redirected after successful login
        bean.setSuccessUrl("/home");
        // 未授权时跳转的界面;
        bean.setUnauthorizedUrl("/error");

        // filterChainDefinitions interceptor map must use: LinkedHashMap, because it must ensure order
        Map<String, String> filterMap = new LinkedHashMap<>();
        // Release login page
        filterMap.put("/login", "anon");
        // Configure the exit filter, the specific exit code Shiro has been implemented
        filterMap.put("/logout", "logout");
        //Configure the address that remember me or pass authentication
        filterMap.put("/user/userList", "user");
        filterMap.put("/", "user");

        // Configure links that will not be intercepted, judge from top to bottom
        filterMap.put("/css/*", "anon");
        filterMap.put("/js/*", "anon");
        filterMap.put("/js/*/*", "anon");
        filterMap.put("/js/*/*/*", "anon");
        filterMap.put("/images/*/**", "anon");
        filterMap.put("/img/*/**", "anon");
        filterMap.put("/jslib/*/**", "anon");
        filterMap.put("/layui/*", "anon");
        filterMap.put("/layui/*/**", "anon");
        filterMap.put("/treegrid/*", "anon");
        filterMap.put("/treegrid/*/*", "anon");
        filterMap.put("/fragments/*", "anon");
        filterMap.put("/layout", "anon");
        filterMap.put("/home", "anon");
        filterMap.put("/user/login", "anon");

        // <!-- authc: All URLs must be authenticated before they can be accessed; anon: All URLs can be accessed anonymously [Release]-->
        filterMap.put("/**", "kickout,authc");
        filterMap.put("/*/*", "authc");
        filterMap.put("/*/*/*", "authc");
        filterMap.put("/*/*/*/**", "authc");

        // Add shiro filter
        bean.setFilterChainDefinitionMap(filterMap);
        logger.info("Shiro interceptor factory class injected successfully");

        return bean;
    }

    /**
     * 1. Shiro security manager sets realm authentication and ehcache cache management
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();

        // Associated realm
        manager.setRealm(shiroRealm());
        //Inject ehcache cache manager;
        manager.setCacheManager(ehCacheManager());
        //Inject the session manager;
        manager.setSessionManager(sessionManager());
        //Inject cookies to remember me manager
        manager.setRememberMeManager(rememberMeManager());

        return manager;
    }

    /**
     * 2. Create an authentication Realm
     */
    @Bean
    public MyRealm shiroRealm() {
        MyRealm realm = new MyRealm();
        realm.setCredentialsMatcher(hashedCredentialsMatcher());
        return realm;
    }


    /**
     * 3. Credential matcher (Because our password verification is handed over to Shiro's SimpleAuthenticationInfo for processing
     * So we need to modify the code in doGetAuthenticationInfo, and change the password generation rule to be consistent with the verification logic;)
     *
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");// Hash algorithm: MD5 algorithm is used here;
        hashedCredentialsMatcher.setHashIterations(2);// The number of hashes, such as hashing twice, is equivalent to // md5(md5(""));
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return hashedCredentialsMatcher;
    }


    /**
     * 8、RememberMe Function of
     */
    // 创建 Cookie
    @Bean
    public SimpleCookie remeberMeCookie() {
        logger.info("Remember me, set cookie expiration time！");
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        // //Remember my cookie effective time is 30 days, in seconds [10 days]
        cookie.setMaxAge(864000);
        // Set up a read-only model
        //cookie.setHttpOnly(true);
        return cookie;
    }

    /**
     * 7、Configure cookie remember me manager
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager(){
        logger.debug("Configure cookie remember me manager！");
        CookieRememberMeManager cookieRememberMeManager=new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(remeberMeCookie());
        return cookieRememberMeManager;
    }


    /**
     *
     * 10、Function description: Multi-device login restriction for the same user
     *
     * @param:
     * @return:
     */
    public KickoutSessionFilter kickoutSessionFilter(){
        KickoutSessionFilter kickoutSessionFilter = new KickoutSessionFilter();
        //Use cacheManager to obtain the corresponding cache to cache the user login session; used to save the user-session relationship;
        //Here we still use the cache Manager() cache management implemented by ehcache used by shiro before
        //You can also write another one and reconfigure custom cache attributes such as cache time
        kickoutSessionFilter.setCacheManager(ehCacheManager());
        // Used to get the session to kick out based on the session ID；
        kickoutSessionFilter.setSessionManager(sessionManager());
        //Whether to kick out those who log in later, the default is false; that is, the user who logs in in the latter kicks out the user who logs in in the former; the order of kicking out.
        kickoutSessionFilter.setKickoutAfter(false);
        //The maximum number of sessions for the same user, the default is 1. For example, 2 means that the same user allows up to two people to log in at the same time；
        kickoutSessionFilter.setMaxSession(1);
        //The address to redirect to after being kicked out;
        kickoutSessionFilter.setKickoutUrl("/login?kickout=1");
        return kickoutSessionFilter;
    }


    /**
     * 4. ehcache cache manager; shiro integrates ehcache:
     * Through the security manager: securityManager
     * Singleton cache prevents hot deployment restart failure
     * @return EhCacheManager
     */
    @Bean
    public EhCacheManager ehCacheManager(){
        logger.debug("shiro integrates ehcache cache：ShiroConfiguration.getEhCacheManager()");
        EhCacheManager ehcache = new EhCacheManager();
        CacheManager cacheManager = CacheManager.getCacheManager("shiro");
        if(cacheManager == null){
            try {
                cacheManager = CacheManager.create(ResourceUtils.getInputStreamForPath("classpath:config/ehcache.xml"));
            } catch (CacheException | IOException e) {
                e.printStackTrace();
            }
        }
        ehcache.setCacheManager(cacheManager);
        return ehcache;
    }

    /**
     *
     * 5、Function description: sessionManager adds session cache operation DAO
     *
     * @param:
     * @return:
     */
    @Bean
    public DefaultWebSessionManager sessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();

		sessionManager.setSessionDAO(enterCacheSessionDAO());
		sessionManager.setSessionIdCookie(sessionIdCookie());
		return sessionManager;
	}

    /**
     * 6. Implementation of EnterpriseCacheSessionDAO shiro sessionDao layer;
     * Provides session maintenance for the cache function. By default, it is implemented using MapCache, and ConcurrentHashMap is used internally to save cached sessions.
     */
    @Bean
    public EnterpriseCacheSessionDAO enterCacheSessionDAO() {
        EnterpriseCacheSessionDAO enterCacheSessionDAO = new EnterpriseCacheSessionDAO();
        enterCacheSessionDAO.setActiveSessionsCacheName("shiro-activeSessionCache");
        return enterCacheSessionDAO;
    }


    /**
     *
     * Function description: Customize the configuration of the session name in the cookie
     *
     * @param:
     * @return:
     */
    @Bean
    public SimpleCookie sessionIdCookie() {
        //DefaultSecurityManager
        SimpleCookie simpleCookie = new SimpleCookie();
        //sessionManager.setCacheManager(ehCacheManager());
        //If the "HttpOnly" attribute is set in the Cookie, the cookie information will not be read by the program (JS script, Applet, etc.), which can effectively prevent XSS attacks.
        simpleCookie.setHttpOnly(true);
        simpleCookie.setName("SHRIOSESSIONID");
        //Unit second
        simpleCookie.setMaxAge(86400);
        return simpleCookie;
    }



    /**
     * Integrate Shiro tags
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}
