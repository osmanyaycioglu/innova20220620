package com.training.javaee.cdi.interceptors;


public class MyCallee {

    @CheckProcess
    public String process(final String taskName) {
        return taskName + " processed.";
    }

}
