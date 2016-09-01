package com.learn.web.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by liulinhui on 16-9-1.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping("/index.html")
    public String loginIn(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        return "Login/login.ftl";
    }
}
