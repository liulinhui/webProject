package com.learn.web.test.ThreadTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by liulinhui on 2016/11/26.
 */
@Controller
@RequestMapping("/ThreadTest")
public class PoolTestController {
    @Autowired
    private Starter starter;


    @RequestMapping(value="/ThreadTest.html",method = {RequestMethod.GET})
    @ResponseBody
    public void ThreadTest() {
        starter.start();
    }
}
