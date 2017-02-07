package com.learn.resteasy.guice;
import com.google.inject.Binder;
import com.google.inject.Module;
/**
 * Created by liulinhui on 2017/2/7.
 */
public class HelloModule implements Module {
    public void configure(final Binder binder)
    {
        binder.bind(HelloResource.class);
        binder.bind(Greeter.class).to(DefaultGreeter.class);
    }
}
