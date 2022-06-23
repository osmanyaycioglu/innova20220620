package com.training.javaee.person.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.javaee.person.services.PersonQueryService;
import com.training.javaee.rest.mappers.PersonMapper;
import com.training.javaee.rest.models.PersonRest;


@RestController
@RequestMapping("/api/v1/person/query")
public class PersonQueryRest {

    @Autowired
    private PersonQueryService queryService;

    @GetMapping("/get/one/{pid}")
    public PersonRest getOnePerson(@PathVariable("pid") final Long personId) {
        return PersonMapper.toPersonRest(this.queryService.getOnePerson(personId));
    }

    @GetMapping("/get/all")
    public List<PersonRest> getAllPersons() {
        return PersonMapper.toPersonRests(this.queryService.getAllPersons());
    }

    @GetMapping("/get/by/surname/{sur}")
    public List<PersonRest> getPersonBySurname(@PathVariable("sur") final String surname) {
        return PersonMapper.toPersonRests(this.queryService.getPersonsBySurname(surname));
    }


}
