package com.learn.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by liulinhui on 2017/1/2.
 */
public class Client {
    public static void main(String[] args) {
        Subject realSubject=new RealSubject();
        DynamicProxy handler=new DynamicProxy(realSubject);
        Subject subject=(Subject)(handler.getProxyObject(realSubject.getClass().getClassLoader(),realSubject.getClass().getInterfaces()));
        System.out.println(subject.getClass().getName());
        subject.rent();
        subject.hello("world");
    }
}
