/**
 * Created by liulinhui on 16-8-25.
 */
package com.learn.web.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpMethod.GET;

@Controller
@RequestMapping("/test")
public class test{
    @Value("test")
    private String test;

    @RequestMapping("/index.html")
    public String index(ModelMap model, HttpServletRequest request) throws Exception{
        model.put("webTest",test);
        return "test.ftl";
    }


}