package com.training.javaee.rest;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.training.javaee.ejb.MySingletonEjb;
import com.training.javaee.ejb.MyStatefulEjb;
import com.training.javaee.ejb.MyStatelessEjb;

@Path("/hello")
@RequestScoped
public class Hello implements Serializable {

    private volatile int                 localCounter  = 0;
    private final AtomicInteger          atomicInteger = new AtomicInteger();
    private final List<String>           list          = new Vector<>();
    private final Map<String, String>    map           = new ConcurrentHashMap<>();
    private final ReentrantReadWriteLock lock          = new ReentrantReadWriteLock();

    @EJB
    private MySingletonEjb               mySingletonEjb;
    @EJB
    private MyStatefulEjb                myStatefulEjb;
    @EJB
    private MyStatelessEjb               myStatelessEjb;


    @PostConstruct
    public void xyz() {
        System.out.println("Created new Hello");
    }

    @PreDestroy
    public void abc() {
        this.myStatefulEjb.remove();
        System.out.println("Hello destroyed");
    }

    public synchronized void inc() {
        this.localCounter++;
    }

    public void inc2() {
        try {
            this.lock.writeLock()
                     .lock();

        } catch (Exception eLoc) {

        } finally {
            this.lock.writeLock()
                     .unlock();
        }

    }


    @Path("/count")
    @GET
    public String count(@QueryParam("name") final String name) {
        return "Local : " + this.localCounter++ + " " + this.mySingletonEjb.hello(name);
    }

    @Path("/stateful/count")
    @GET
    public String countStateful(@QueryParam("name") final String name) {

        return "Local : " + this.localCounter++ + " " + this.myStatefulEjb.hello(name);
    }

    @Path("/stateless/count")
    @GET
    public String countStateless(@QueryParam("name") final String name) {
        String helloLoc = this.myStatelessEjb.hello(name);
        return "Local : " + this.localCounter++ + " " + helloLoc;
    }

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
