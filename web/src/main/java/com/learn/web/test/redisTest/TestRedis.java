package com.learn.web.test.redisTest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by linkage on 2016-12-14.
 */
@Controller
@RequestMapping("/redisTest")
public class TestRedis {

    @Autowired
    private RedisClientTemplate redisClientTemplate;

    @RequestMapping("/test")
    @ResponseBody
    public String index() {
        for (int i = 0; i < 1000; i++)
            redisClientTemplate.set("index" + i, "操你大爷的，这是第"+i+"个数啦！！！！");
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < 1000; i++)
            sb.append(redisClientTemplate.get("index" + i));
        JSONObject jsonObject=new JSONObject(sb);
        return jsonObject.toString();
    }
}
