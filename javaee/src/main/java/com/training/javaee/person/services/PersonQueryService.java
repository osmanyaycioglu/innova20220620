package com.training.javaee.person.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import com.training.javaee.person.data.PersonDao;
import com.training.javaee.person.models.Person;

@Singleton
@LocalBean
public class PersonQueryService {

    @EJB
    private PersonDao personDao;

    public Person getOnePerson(final Long personId) {
        return this.personDao.getOnePerson(personId);
    }

    public List<Person> getAllPersons() {
        return null;
    }

    public List<Person> getPersonsBySurname(final String surname) {
        return null;

    }

}
