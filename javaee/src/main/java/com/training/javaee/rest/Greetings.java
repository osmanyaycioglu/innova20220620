package com.training.javaee.rest;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.training.javaee.rest.models.PersonRest;

@Path("/greeting")
@Produces(MediaType.TEXT_PLAIN)
public class Greetings {

    // /javaee/rest/greeting/say/hello/XXXXXX   -> GET methodu
    @Path("/say/hello/{abc}")
    @GET
    public String sayHello(@PathParam("abc") String name) {
        return "Hello " + name;
    }

    // /javaee/rest/greeting/say/hello/XXXXXX/surname/YYYYYYY   -> GET methodu
    @Path("/say/hello/{abc}/surname/{xyz}")
    @GET
    public String sayHello(@PathParam("abc") String name,
                           @PathParam("xyz") String surname) {
        return "Hello " + name + " " + surname;
    }

    // /javaee/rest/greeting/say/hello2?abc=osman   -> GET methodu
    @Path("/say/hello2")
    @GET
    public String sayHello2(@QueryParam("abc") String name) {
        return "Hello " + name;
    }

    // /javaee/rest/greeting/say/hello3?abc=osman&xyz=yay   -> GET methodu
    @Path("/say/hello3")
    @GET
    public String sayHello3(@QueryParam("abc") String name,
                            @QueryParam("xyz") String surname) {
        return "Hello " + name + " " + surname;
    }

    @Path("/say/hello3a/{abc}")
    @GET
    public String sayHello3a(@PathParam("abc") String name,
                             @QueryParam("xyz") String surname) {
        return "Hello " + name + " " + surname;
    }

    // /javaee/rest/greeting/say/hello4;abc=osman;xyz=yay   -> GET methodu
    @Path("/say/hello4")
    @GET
    public String sayHello4(@MatrixParam("abc") String name,
                            @MatrixParam("xyz") String surname) {
        return "Hello " + name + " " + surname;
    }

    @Path("/say/hello5")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String sayHello5(PersonRest personParam) {
        return "Hello " + personParam;
    }

    @Path("/say/hello6")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PersonRest sayHello6(PersonRest personParam) {
        personParam.setName("test");
        return personParam;
    }

    @Path("/say/hello7")
    @POST
    @Consumes({
                MediaType.APPLICATION_JSON,
                MediaType.APPLICATION_XML
    })
    @Produces({
                MediaType.APPLICATION_JSON,
                MediaType.APPLICATION_XML
    })
    public PersonRest sayHello7(PersonRest personParam) {
        personParam.setName("test");
        return personParam;
    }

    @Path("/say/hello8")
    @GET
    public String sayHello8(@HeaderParam("abc") String name,
                            @HeaderParam("xyz") String surname) {
        return "Hello " + name + " " + surname;
    }

    @Path("/say/hello9")
    @POST
    public String sayHello9(@FormParam("abc") String name,
                            @FormParam("xyz") String surname) {
        return "Hello " + name + " " + surname;
    }

    @Path("/say/hello10")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public PersonRest sayHello10(@BeanParam PersonRest personParam) {
        personParam.setName("test");
        return personParam;
    }

    @Path("/say/hello11")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sayHello11(PersonRest personParam) {
        personParam.setName("test");
        return Response.status(Status.OK)
                       .header("test-header",
                               "tes value")
                       .entity(personParam)
                       .build();
    }


    @Context
    private HttpServletRequest servletRequest;

    @Path("/group/{op}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sayHello12(@PathParam("op") String op) {
        switch (op) {
            case "activate":
                try {
                    BufferedReader readerLoc = servletRequest.getReader();
                    PersonRest person;
                    return Response.status(Status.OK)
                                   .header("test-header",
                                           "tes value")
                                   .entity("OK")
                                   .build();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            case "deactivate":
                String parameterLoc = servletRequest.getParameter("pid");
                return Response.status(Status.OK)
                               .header("test-header",
                                       "tes value")
                               .entity("xyz")
                               .build();

            default:
                return Response.status(Status.BAD_REQUEST)
                               .header("test-header",
                                       "tes value")
                               .entity("operasyon hatalı")
                               .build();
        }
    }


}
