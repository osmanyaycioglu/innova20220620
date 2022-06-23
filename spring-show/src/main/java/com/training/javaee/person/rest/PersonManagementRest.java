package com.training.javaee.person.rest;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.javaee.rest.models.PersonRest;

@RestController
@RequestMapping("/api/v1/person/management")
// @Path("/api/v1/person/management")
public class PersonManagementRest {

    @PostMapping("/update")
    //    @POST
    //    @Path("/update")
    //    @Consumes(MediaType.APPLICATION_JSON)
    public String update(final PersonRest person) {
        return "OK";
    }

}
