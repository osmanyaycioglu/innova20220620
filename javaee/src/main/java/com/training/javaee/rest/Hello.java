package com.training.javaee.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/hello")
public class Hello {


    // /javaee/rest/hello/world GET methodu
    @Path("/world")
    @GET
    public String hello() {
        return "Hello world GET";
    }

    // /javaee/rest/hello/world POST methodu
    @Path("/world")
    @POST
    public String helloPost() {
        return "Hello world POST";
    }

}
