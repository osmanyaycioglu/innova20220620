package com.training.javaee.person.rest;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import com.training.javaee.rest.models.Person;

@Path("/api/v1/person/provison")
public class PersonProvisionRest {

    @POST
    @Path("activate")
    @Consumes(MediaType.APPLICATION_JSON)
    public String activate(@Valid Person person) {
        if (person.getName() == null) {
            throw new IllegalArgumentException("name null olmaz");
        }
        return "OK";
    }

    @GET
    @Path("/deactivate/{pid}")
    public String deactivate(@PathParam("pid") Long personId) {
        return "OK";
    }


    @GET
    @Path("/suspend/{pid}")
    public String suspend(@PathParam("pid") Long personId) {
        return "OK";
    }


}
