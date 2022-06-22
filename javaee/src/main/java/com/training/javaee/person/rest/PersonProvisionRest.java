package com.training.javaee.person.rest;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import com.training.javaee.person.services.PersonProvisionService;
import com.training.javaee.rest.mappers.PersonMapper;
import com.training.javaee.rest.models.PersonRest;

@Path("/api/v1/person/provison")
public class PersonProvisionRest {

    @EJB
    private PersonProvisionService provisionService;

    @POST
    @Path("activate")
    @Consumes(MediaType.APPLICATION_JSON)
    public String activate(@Valid final PersonRest personRest) {
        if (personRest.getName() == null) {
            throw new IllegalArgumentException("name null olmaz");
        }
        this.provisionService.activatePerson(PersonMapper.toPerson(personRest));
        return "OK";
    }

    @GET
    @Path("/deactivate/{pid}")
    public String deactivate(@PathParam("pid") final Long personId) {
        return "OK";
    }


    @GET
    @Path("/suspend/{pid}")
    public String suspend(@PathParam("pid") final Long personId) {
        return "OK";
    }


}
