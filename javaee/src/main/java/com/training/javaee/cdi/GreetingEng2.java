package com.training.javaee.cdi;

import javax.enterprise.inject.Alternative;

@Alternative
public class GreetingEng2 implements IGreeting {

    @Override
    public String sayHello(final String nameParam) {
        return "Hello " + nameParam;
    }

    @Override
    public String sayGoodbye(final String nameParam) {
        return "Goodbye " + nameParam;
    }

}
