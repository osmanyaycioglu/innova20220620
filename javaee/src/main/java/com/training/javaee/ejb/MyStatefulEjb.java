package com.training.javaee.ejb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;


@Stateful
@LocalBean
public class MyStatefulEjb implements Serializable {

    private int counter;

    public MyStatefulEjb() {
    }

    public String hello(String nameStringParam) {
        return "Hello " + nameStringParam + " count : " + counter++;
    }

    public int count() {
        return counter;
    }

    @PostConstruct
    public void xyz() {
        System.out.println("Created new MyStatefulEjb");
    }

    @PreDestroy
    public void abc() {
        System.out.println("MyStatefulEjb destroyed");
    }

    @Remove
    public void remove() {
    }

    @PrePassivate
    public void passive() {

    }

    @PostActivate
    public void activate() {

    }


}
