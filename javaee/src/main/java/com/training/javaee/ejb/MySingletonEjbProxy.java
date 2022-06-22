package com.training.javaee.ejb;

public class MySingletonEjbProxy extends MySingletonEjb {


    @Override
    public String hello(final String nameStringParam) {
        // Trans
        // Lock
        String helloLoc = super.hello(nameStringParam);
        // commit yada rollback
        // Unlock
        return helloLoc;
    }

    @Override
    public int count() {
        return super.count();
    }

}
