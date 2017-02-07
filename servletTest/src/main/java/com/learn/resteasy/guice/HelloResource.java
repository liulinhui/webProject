package com.learn.resteasy.guice;

import com.google.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by liulinhui on 2017/2/7.
 */
@Path("hello")
public class HelloResource {
    private final Greeter greeter;

    @Inject
    public HelloResource(final Greeter greeter)
    {
        this.greeter = greeter;
    }

    @GET
    @Path("{name}")
    public String hello(@PathParam("name") final String name) {
        return greeter.greet(name);
    }
}
