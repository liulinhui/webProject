package com.learn.bean;

import java.io.Serializable;

/**
 * Created by linkage on 2016/8/28.
 */
public class user1 implements Serializable{
    public static final long serialVersionUID = 1L;
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
