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
import java.util.List;

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
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            personList.add(i,person);
        ProtostuffTest protostuffTest = new ProtostuffTest();
//        redisClientTemplate.setex("对象".getBytes(), 3000,protostuffTest.serializeProtoStuffProductsList(personList).toArray());
        return protostuffTest.deserializeProtoStuffDataListToProductsList(
                protostuffTest.serializeProtoStuffProductsList(personList)).size()+"";
    }
}
