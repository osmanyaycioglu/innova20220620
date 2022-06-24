package com.training.javaee.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/cdi2")
@ApplicationScoped
@Consumes(MediaType.TEXT_PLAIN)
public class CdiRest2 {

    @Inject
    @Named("gTr")
    private IGreeting greeting;

    @Inject
    @Alternative
    private IGreeting greeting2;

    @Inject
    @Named("dynGr")
    private IGreeting greeting3;


    @Path("/hello")
    @GET
    public String hello(@QueryParam("name") final String name) {
        return this.greeting.sayHello(name);
    }

    @Path("/hello2")
    @GET
    public String hello2(@QueryParam("name") final String name) {
        return this.greeting2.sayHello(name);
    }

    @Path("/hello3")
    @GET
    public String hello3(@QueryParam("name") final String name) {
        return this.greeting3.sayHello(name);
    }

    @Path("/goodbye")
    @GET
    public String goodbye(@QueryParam("name") final String name) {
        return this.greeting.sayGoodbye(name);
    }

}
