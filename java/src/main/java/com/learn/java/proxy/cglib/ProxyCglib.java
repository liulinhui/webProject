package com.learn.java.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用cglib动态代理
 * Created by liulinhui on 2017/1/2.
 */
public class ProxyCglib implements MethodInterceptor {
    private Object target;

    /**
     * 创建代理对象
     *
     * @param target 代理的目标对象
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        //回掉方法
        enhancer.setCallback(this);
        //创建代理对象
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("事物开始");
        methodProxy.invokeSuper(o, objects);
        System.out.println("事务结束");
        return null;
    }
}
