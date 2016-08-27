/**
 * Created by liulinhui on 16-8-25.
 */
package com.learn.web.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/test")
public class test{
    @Value("${test}")
    private String test;

    @RequestMapping(value = "/index.html",method = {RequestMethod.GET})
    public String index(ModelMap model, HttpServletRequest request) throws Exception{
        model.put("webTest",test);
        return "test.ftl";
    }


}