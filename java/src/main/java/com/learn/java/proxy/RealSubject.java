package com.learn.java.proxy;

/**
 * Created by liulinhui on 2017/1/2.
 */
public class RealSubject implements Subject {
    @Override
    public void rent() {
        System.out.println("i want rent my house!!");
    }

    @Override
    public void hello(String string) {
        System.out.println("hello:"+string);
    }
}
