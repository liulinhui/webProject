package com.learn.springTest.ApplicationContext.init;

/**
 * Created by linkage on 2016-11-03.
 */
public class Example {
    public Example(){
        System.out.println("无参数的构造器");
    }

    public void setName(String name){
        System.out.println("注入的name="+name);
    }
}
