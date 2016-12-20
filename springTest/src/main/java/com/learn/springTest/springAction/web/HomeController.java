package com.learn.springTest.springAction.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by linkage on 2016-12-19.
 */
@Controller
public class HomeController {
    private static Logger logger = Logger.getLogger(HomeController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(ModelMap model, HttpServletRequest request) {
        logger.info("lalalalal");
        model.put("test","fuck");
        return "home";
    }
}
