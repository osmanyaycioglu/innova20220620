package com.training.javaee.person.services;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import com.training.javaee.person.models.Person;

@Singleton
@LocalBean
public class PersonProvisionService {


    public void activatePerson(final Person person) {

    }

    public void deactivatePerson(final Long personId) {

    }

    public void suspendPerson(final Long personId) {

    }

}
