package com.training.javaee.person.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.training.javaee.person.services.PersonQueryService;
import com.training.javaee.rest.mappers.PersonMapper;
import com.training.javaee.rest.models.PersonRest;

@Path("/api/v1/person/query")
@Produces(MediaType.APPLICATION_JSON)
public class PersonQueryRest {

    @EJB
    private PersonQueryService queryService;

    @GET
    @Path("/get/one/{pid}")
    public PersonRest getOnePerson(@PathParam("pid") final Long personId) {
        return PersonMapper.toPersonRest(this.queryService.getOnePerson(personId));
    }

    @GET
    @Path("/get/all")
    public List<PersonRest> getAllPersons() {
        return PersonMapper.toPersonRests(this.queryService.getAllPersons());
    }

    @GET
    @Path("/get/by/surname/{sur}")
    public List<PersonRest> getPersonBySurname(@PathParam("sur") final String surname) {
        return PersonMapper.toPersonRests(this.queryService.getPersonsBySurname(surname));
    }


}
