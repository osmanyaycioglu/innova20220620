package com.training.javaee.cdi;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class GreetingConfig {

    @Produces
    @Named("dynGr")
    public IGreeting greetingBean() {
        // Db ye git config

        return new GreetingTr();
    }

    @Produces
    @Named("dynEng")
    public IGreeting greetingBean2() {
        return new GreetingDynamic("Hi",
                                   "bye");
    }


    @Produces
    @Named("dynTr")
    public IGreeting greetingBean3() {
        return new GreetingDynamic("Selam",
                                   "görüşürüz");
    }

}
