package com.training.javaee.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.inject.Named;

import com.training.javaee.cdi.IGreeting;


@Singleton
@LocalBean
public class MySingletonEjb {

    private int       counter;

    @Inject
    @Named("dynTr")
    private IGreeting greeting;

    public MySingletonEjb() {
    }

    @Lock(LockType.WRITE)
    public String hello(final String nameStringParam) {
        return "Hello "
               + nameStringParam
               + " count : "
               + this.counter++
               + " "
               + this.greeting.sayHello(nameStringParam);
    }

    @Lock(LockType.READ)
    public int count() {
        return this.counter;
    }

}
