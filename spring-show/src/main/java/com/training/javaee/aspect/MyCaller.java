package com.training.javaee.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyCaller {

    @Autowired
    private MyCallee callee;


    public String execute(final String taskName) {
        return this.callee.process(taskName);
    }


}
