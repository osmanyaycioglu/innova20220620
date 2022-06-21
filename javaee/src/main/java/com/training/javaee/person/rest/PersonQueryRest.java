package com.training.javaee.person.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.training.javaee.rest.models.Person;

@Path("/api/v1/person/query")
public class PersonQueryRest {


    @GET
    @Path("/get/one/{pid}")
    public Person getOnePerson(@PathParam("pid") Long personId) {
        return null;
    }

    @GET
    @Path("/get/all")
    public List<Person> getAllPersons() {
        return null;
    }

    @GET
    @Path("/get/by/surname/{sur}")
    public List<Person> getOnePerson(@PathParam("sur") String surname) {
        return null;
    }


}
