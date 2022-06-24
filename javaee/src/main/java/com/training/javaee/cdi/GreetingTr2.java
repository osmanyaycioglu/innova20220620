package com.training.javaee.cdi;

import javax.enterprise.inject.Alternative;

@Alternative
public class GreetingTr2 implements IGreeting {

    @Override
    public String sayHello(final String nameParam) {
        return "Merhaba " + nameParam;
    }

    @Override
    public String sayGoodbye(final String nameParam) {
        return "Güle güle " + nameParam;
    }

}
