package com.training.javaee.cdi;

public class GreetingDynamic implements IGreeting {

    private final String helloPrefix;
    private final String goodbyePrefix;


    public GreetingDynamic(final String helloPrefixParam,
                           final String goodbyePrefixParam) {
        super();
        this.helloPrefix = helloPrefixParam;
        this.goodbyePrefix = goodbyePrefixParam;
    }

    @Override
    public String sayHello(final String nameParam) {
        return this.helloPrefix + " " + nameParam;
    }

    @Override
    public String sayGoodbye(final String nameParam) {
        return this.goodbyePrefix + " " + nameParam;
    }

}
