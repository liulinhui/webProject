package com.learn.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by liulinhui on 2017/1/2.
 */
public class DynamicProxy implements InvocationHandler {

    private Object object;  //真实需要代理的对象

    public DynamicProxy(Object object){
        this.object=object;
    }

    public Object getProxyObject(ClassLoader classLoader,Class<?>[] interfaces){
        return Proxy.newProxyInstance(classLoader,interfaces,this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before rent house");
        System.out.println("Method:"+method);
        method.invoke(object,args);
        System.out.println("after rent house");
        return null;
    }
}
