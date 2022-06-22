package com.training.javaee.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class MyStatelessEjb {

    private int counter;

    public MyStatelessEjb() {
    }

    public String hello(final String nameStringParam) {
        return "Hello " + nameStringParam + " count : " + this.counter++;
    }

    public int count() {
        return this.counter;
    }

}
