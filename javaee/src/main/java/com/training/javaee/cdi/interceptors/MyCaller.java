package com.training.javaee.cdi.interceptors;

import javax.inject.Inject;

public class MyCaller {

    @Inject
    private MyCallee callee;


    public String execute(final String taskName) {
        return this.callee.process(taskName);
    }


}
