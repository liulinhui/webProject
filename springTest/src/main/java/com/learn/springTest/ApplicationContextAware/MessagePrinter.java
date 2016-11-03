package com.learn.springTest.ApplicationContextAware;

/**
 * Created by linkage on 2016-11-03.
 */
public class MessagePrinter implements MessageService {
    @Override
    public void printMessage() {
        System.out.println("打印机打印消息!");
    }
}
