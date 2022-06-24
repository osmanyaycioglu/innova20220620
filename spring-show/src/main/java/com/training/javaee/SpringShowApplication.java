package com.training.javaee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringShowApplication {

    public static void main(final String[] args) {
        SpringApplication.run(SpringShowApplication.class,
                              args);
    }

}
