package com.training.javaee.rest.mappers;

import java.util.ArrayList;
import java.util.List;

import com.training.javaee.person.models.Person;
import com.training.javaee.rest.models.PersonRest;

public class PersonMapper {

    public static Person toPerson(final PersonRest personRest) {
        Person personLoc = new Person();
        personLoc.setName(personRest.getName());
        personLoc.setSurname(personRest.getSurname());
        personLoc.setPassword(personRest.getPassword());
        personLoc.setHeight(personRest.getHeight());
        personLoc.setWeight(personRest.getWeight());
        personLoc.setAddress(personRest.getAddress());
        personLoc.setPhones(personRest.getPhones());
        return personLoc;
    }

    public static PersonRest toPersonRest(final Person person) {
        PersonRest personLoc = new PersonRest();
        personLoc.setName(person.getName());
        personLoc.setSurname(person.getSurname());
        personLoc.setPassword(person.getPassword());
        personLoc.setHeight(person.getHeight());
        personLoc.setWeight(person.getWeight());
        personLoc.setAddress(person.getAddress());
        personLoc.setPhones(person.getPhones());
        return personLoc;
    }

    public static List<PersonRest> toPersonRests(final List<Person> person) {
        List<PersonRest> personRestsLoc = new ArrayList<>();
        for (Person personLoc : person) {
            personRestsLoc.add(toPersonRest(personLoc));
        }
        return personRestsLoc;
    }


}
