package com.learn.web.test.redisTest;

import org.apache.log4j.Logger;
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
    private static Logger logger = Logger.getLogger(TestRedis.class);
    @Autowired
    private RedisClientTemplate redisClientTemplate;

    @RequestMapping(value = "/test",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String index() {
        logger.error("===========error错误日志测试=================================");
        logger.warn("==============warn错误日志测试=================================");
        logger.fatal("==============fatal错误日志测试=================================");
        for (int i = 0; i < 1000; i++)
            redisClientTemplate.set("index" + i, "操你大爷的，这是第" + i + "个数啦！！！！");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 1000; i++)
            sb.append(redisClientTemplate.get("index" + i));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",sb.toString());
        return jsonObject.toString();
    }
}
