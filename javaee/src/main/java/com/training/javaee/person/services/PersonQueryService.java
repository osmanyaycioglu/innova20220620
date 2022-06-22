package com.training.javaee.person.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import com.training.javaee.person.models.Person;

@Singleton
@LocalBean
public class PersonQueryService {

    public Person getOnePerson(final Long personId) {
        return null;
    }

    public List<Person> getAllPersons() {
        return null;
    }

    public List<Person> getPersonsBySurname(final String surname) {
        return null;

    }

}
