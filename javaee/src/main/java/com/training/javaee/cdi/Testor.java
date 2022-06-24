package com.training.javaee.cdi;

import java.io.Serializable;

import javax.inject.Inject;

// @SessionScoped
public class Testor implements Serializable {

    private int count = 0;

    // Field Injection
    @Inject
    private MyCdiBean       cdiBean1;

    private final MyCdiBean cdiBean2;

    private MyCdiBean       cdiBean3;

    // Constructor Injection
    @Inject
    public Testor(final MyCdiBean cdiBean2Param) {
        super();
        this.cdiBean2 = cdiBean2Param;
    }

    public String testMe1(final String name) {
        this.count++;
        return "Count : " + this.count + " " + this.cdiBean1.testMe(name);
    }

    public String testMe2(final String name) {
        this.count++;
        return "Count : " + this.count + " " + this.cdiBean2.testMe(name);
    }

    public String testMe3(final String name) {
        this.count++;
        return "Count : " + this.count + " " + this.cdiBean3.testMe(name);
    }

    public MyCdiBean getCdiBean3() {
        return this.cdiBean3;
    }

    // Method Injection
    @Inject
    public void setCdiBean3(final MyCdiBean cdiBean3Param) {
        this.cdiBean3 = cdiBean3Param;
    }


}
