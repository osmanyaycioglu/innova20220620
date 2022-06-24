package com.training.javaee.cdi.interceptors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/cdi3")
@ApplicationScoped
@Consumes(MediaType.TEXT_PLAIN)
public class CdiRest3 {

    @Inject
    private MyCaller myCaller;

    @Path("/process")
    @GET
    @CheckProcess
    public String process(@QueryParam("name") final String name) {
        return this.myCaller.execute(name);
    }

}
