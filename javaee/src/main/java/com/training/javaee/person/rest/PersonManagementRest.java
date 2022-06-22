package com.training.javaee.person.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.training.javaee.rest.models.PersonRest;

@Path("/api/v1/person/management")
public class PersonManagementRest {

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public String update(PersonRest person) {
        return "OK";
    }

}
