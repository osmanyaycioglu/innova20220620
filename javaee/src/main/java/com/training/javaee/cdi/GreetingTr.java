package com.training.javaee.cdi;

import javax.inject.Named;

@Named("gTr")
public class GreetingTr implements IGreeting {

    @Override
    public String sayHello(final String nameParam) {
        return "Merhaba " + nameParam;
    }

    @Override
    public String sayGoodbye(final String nameParam) {
        return "Güle güle " + nameParam;
    }

}
