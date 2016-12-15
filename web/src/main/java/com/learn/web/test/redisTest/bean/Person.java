package com.learn.web.test.redisTest.bean;

/**
 * Created by linkage on 2016-12-15.
 */
public class Person {
    private String name;
    private String sex;
    private int age;
    private int height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String toString(){
        return "name="+this.name+",age="+this.age+",height="+this.height+",sex="+this.sex;
    }
}
