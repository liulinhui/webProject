package com.learn.web.controller.backEnd.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by linkage on 2016/9/4.
 */
@Controller
@RequestMapping("/backend")
public class MainController {
    /**
     * 主页
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = {"/",""}, method = {RequestMethod.GET})
    public String index(ModelMap model, HttpServletRequest request) {
        return "backEnd/main.ftl";
    }

    /**
     * 首页内容/首页代码
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/code.html", method = {RequestMethod.GET})
    public String code(ModelMap model, HttpServletRequest request) {
        return "backEnd/main/code.ftl";
    }

}
