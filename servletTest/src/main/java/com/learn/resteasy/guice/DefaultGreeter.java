package com.learn.resteasy.guice;

/**
 * Created by liulinhui on 2017/2/7.
 */
public class DefaultGreeter implements Greeter {
    @Override
    public String greet(final String name) {
        return "Hello " + name;
    }
}
