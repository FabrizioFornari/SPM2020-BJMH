package com.amrengp.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Title: LoginController
 * @Description:
 * @version: 1.0
 */
@Controller
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("login")
    public String tologin(){
        logger.info("Targeted landing page");
        return "login";
    }

    @RequestMapping("home")
    public String home(){
        logger.info("Orientation homepage");
        return "home";
    }
    @RequestMapping("main/main")
    public String main(){
        logger.info("Right side of backstage homepage");
        return "main/main";
    }

    @RequestMapping("logout")
    public String logout(){
        logger.info("Exit system");
        Subject subject = SecurityUtils.getSubject();
        subject.logout(); // shiro deletes session information at the bottom of the session
        return "redirect:login";
    }

}
