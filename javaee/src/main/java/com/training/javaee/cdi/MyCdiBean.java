package com.training.javaee.cdi;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class MyCdiBean {

    public String testMe(final String name) {
        return "Tested : " + name;
    }

}
