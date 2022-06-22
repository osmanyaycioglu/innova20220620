package com.training.javaee.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;


@Singleton
@LocalBean
public class MySingletonEjb {

    private int counter;

    public MySingletonEjb() {
    }

    @Lock(LockType.WRITE)
    public String hello(String nameStringParam) {
        return "Hello " + nameStringParam + " count : " + counter++;
    }

    @Lock(LockType.READ)
    public int count() {
        return counter;
    }

}
