package com.training.javaee.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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

    @Path("/world")
    @PUT
    public String helloPut() {
        return "Hello world PUT";
    }

    @Path("/world")
    @PATCH
    public String helloPatch() {
        return "Hello world PATCH";
    }

    @Path("/world")
    @DELETE
    public String helloDelete() {
        return "Hello world DELETE";
    }

}
