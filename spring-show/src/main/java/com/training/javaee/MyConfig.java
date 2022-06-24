package com.training.javaee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.training.javaee.person.models.Person;
import com.training.javaee.person.services.PersonProvisionService;

@Configuration
public class MyConfig {

    @Bean("deneme")
    public Person personBean() {
        return new Person();
    }

    @Bean
    public PersonProvisionService personProvisionService() {
        return new PersonProvisionService();
    }

}
