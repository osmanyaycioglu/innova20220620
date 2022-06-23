package com.training.javaee.person.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.javaee.person.data.PersonDao;
import com.training.javaee.person.models.Person;

@Service
public class PersonQueryService {

    @Autowired
    private PersonDao personDao;

    public Person getOnePerson(final Long personId) {
        return this.personDao.getOnePerson(personId);
    }

    public List<Person> getAllPersons() {
        return null;
    }

    public List<Person> getPersonsBySurname(final String surname) {
        return this.personDao.getBySurname(surname);

    }

}
