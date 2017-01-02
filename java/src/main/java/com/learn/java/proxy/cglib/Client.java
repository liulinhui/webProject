package com.learn.java.proxy.cglib;

/**
 * Created by liulinhui on 2017/1/2.
 */
public class Client {
    public static void main(String[] args) {
        ProxyCglib proxyCglib = new ProxyCglib();
        RealSubject realSubject = (RealSubject) proxyCglib.getInstance(new RealSubject());
        realSubject.send("fuck");
    }
}
