package com.training.javaee.person.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.javaee.person.services.PersonProvisionService;
import com.training.javaee.rest.mappers.PersonMapper;
import com.training.javaee.rest.models.PersonRest;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/person/provison")
// @Path("/api/v1/person/provison")
public class PersonProvisionRest {

    @Autowired
    private PersonProvisionService provisionService;


    @PostMapping("activate")
    //    @POST
    //    @Path("activate")
    //    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(description = "activater long desceription", summary = "activate person")
    public String activate(@RequestBody @Valid final PersonRest personRest) {
        if (personRest.getName() == null) {
            throw new IllegalArgumentException("name null olmaz");
        }
        this.provisionService.activatePerson(PersonMapper.toPerson(personRest));
        return "OK";
    }

    @GetMapping("/deactivate/{pid}")
    //    @GET
    //    @Path("/deactivate/{pid}")
    public String deactivate(@PathVariable("pid") final Long personId) {
        return "OK";
    }


    @GetMapping("/suspend/{pid}")
    //    @GET
    //    @Path("/suspend/{pid}")
    public String suspend(@PathVariable("pid") final Long personId) {
        return "OK";
    }


}
