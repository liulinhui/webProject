package com.learn.springTest.ApplicationContextAware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by linkage on 2016-11-03.
 */
public class MainTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person llh = (Person) context.getBean("llh", Person.class);
        llh.sendMessage();
    }
}
