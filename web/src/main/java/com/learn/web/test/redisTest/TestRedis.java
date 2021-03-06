package com.learn.web.test.redisTest;

import com.google.common.primitives.Bytes;
import com.learn.web.test.redisTest.bean.Person;
import com.learn.web.test.redisTest.bean.ProtostuffTest;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by linkage on 2016-12-14.
 */
@Controller
@RequestMapping("/redisTest")
public class TestRedis {
    private static Logger logger = Logger.getLogger(TestRedis.class);
    @Autowired
    private RedisClientTemplate redisClientTemplate;

    @RequestMapping(value = "/test", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String index() {
        Person person = new Person();
        person.setAge(9);
        person.setHeight(666);
        person.setName("张伟");
        person.setSex("女人");
        Map<String, Person> map = new HashMap<>();
        List<String> list=new ArrayList<>();
        for (int i = 0; i < 100; i++){
            map.put(i + "", person);
//            list.get(i);
        }
        ProtostuffTest protostuffTest = new ProtostuffTest();
        redisClientTemplate.hmset("对象".getBytes(), protostuffTest.serializeMap(map,String.class,Person.class));
        Map<String, Person> mapRes=protostuffTest.deserializeToMap(
                redisClientTemplate.hgetAll("对象".getBytes()),String.class,Person.class);
        return mapRes.toString();
    }
}
