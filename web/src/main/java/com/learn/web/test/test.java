/**
 * Created by liulinhui on 16-8-25.
 */
package com.learn.web.test;

import com.learn.bean.test.user;
import com.learn.web.persistence.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/test")
public class test{
    @Value("${test}")
    private String test;
    @Autowired
    private TestMapper testMapper;

    @RequestMapping(value = "/index.html",method = {RequestMethod.GET})
    public String index(ModelMap model, HttpServletRequest request) throws Exception{
        model.put("webTest",test);
        List<user> user=testMapper.getUser();
        System.out.println(testMapper.getUser().get(0).getName()+"======="+testMapper.getUser().get(0).getPassword());
        System.out.println(testMapper.getUsername("123").size());
        return "test.ftl";
    }


}