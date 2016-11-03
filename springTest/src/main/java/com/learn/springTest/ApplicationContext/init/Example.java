package com.learn.springTest.ApplicationContext.init;

/**系统创建ApplicationContext容器的时候，默认会预先初始化所有的单例的bean，
 * 调用构造器创建实例对象，然后通过set方法注入依赖的对象实例。
 * 这样的情况下，也就是说会面临着一个问题，容器在初始化的时候会有较大的性能的消耗，
 * 但是一旦初始化完成之后，程序在获取单例的bean的时候，又会获得较好的性能。
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
