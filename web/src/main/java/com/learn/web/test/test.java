/**
 * Created by liulinhui on 16-8-25.
 */
package com.learn.web.test;

import com.learn.bean.test.user;
import com.learn.web.common.exception.BusinessException;
import com.learn.web.persistence.TestMapper;
import com.learn.web.test.springaop.annotation.Log;
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
public class test {
    @Value("${test}")
    private String test;
    @Autowired
    private TestMapper testMapper;

//    @Log(name = "您访问了index方法")
    @RequestMapping(value = "/index.html", method = {RequestMethod.GET})
    public String index(ModelMap model, HttpServletRequest request) throws Exception {
        model.put("webTest", test);
        List<user> user = testMapper.getUser();
        System.out.println(user.get(0).getName() + "=======" + user.get(0).getPassword());
        System.out.println(testMapper.getUsername("123").size());
//        ExceptionTest();
        return "test.ftl";
    }

    public void ExceptionTest() {
        throw new BusinessException("12222","测试异常");
    }


}