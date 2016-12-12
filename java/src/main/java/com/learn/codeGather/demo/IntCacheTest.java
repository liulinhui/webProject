package com.learn.codeGather.demo;

import java.lang.reflect.Field;

/**
 * Created by liulinhui on 2016/12/1.
 */
public class IntCacheTest {
    public static void main(String[] args) throws NoSuchFieldException,IllegalAccessException{
        Class cache=Integer.class.getDeclaredClasses()[0];
        Field myCache=cache.getDeclaredField("cache");
        myCache.setAccessible(true);
        Integer[]newCache=(Integer[])myCache.get(cache);
        newCache[132]=newCache[133];
        int a=2;
        int b=a+a;
        System.out.println(a+"   "+b+"   "+a);
    }
}
