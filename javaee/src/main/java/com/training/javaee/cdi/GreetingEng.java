package com.training.javaee.cdi;

import javax.inject.Named;

@Named("gEng")
public class GreetingEng implements IGreeting {

    @Override
    public String sayHello(final String nameParam) {
        return "Hello " + nameParam;
    }

    @Override
    public String sayGoodbye(final String nameParam) {
        return "Goodbye " + nameParam;
    }

}
