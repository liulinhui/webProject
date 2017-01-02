package com.learn.java.proxy.cglib;

/**
 * Created by liulinhui on 2017/1/2.
 */
public class RealSubject {
    public void send(String str){
        System.out.println("cglib实现的动态代理："+str);
    }
}
