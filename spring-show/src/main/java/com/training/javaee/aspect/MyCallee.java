package com.training.javaee.aspect;

import org.springframework.stereotype.Component;

@Component
public class MyCallee {

    @CheckProcess("test")
    public String process(final String taskName) {
        return taskName + " processed.";
    }

}
