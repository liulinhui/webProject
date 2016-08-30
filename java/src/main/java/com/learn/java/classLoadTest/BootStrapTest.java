package com.learn.java.classLoadTest;


import javax.print.DocFlavor;
import java.net.URL;

/**
 * Created by liulinhui on 16-8-25.
 */
public class BootStrapTest {
    public static void main(String[] args) {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i]);
        }
    }
}
