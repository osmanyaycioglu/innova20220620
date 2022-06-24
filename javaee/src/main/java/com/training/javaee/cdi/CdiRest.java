package com.training.javaee.cdi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/cdi")
@ApplicationScoped
public class CdiRest {

    private int       localCount = 0;
    // Field Injection
    @Inject
    private MyCdiBean cdiBean1;

    private MyCdiBean cdiBean2;

    private MyCdiBean cdiBean3;

    @Inject
    private Testor    testor;

    @Inject
    public CdiRest(final MyCdiBean cdiBean2) {
        super();
        this.cdiBean2 = cdiBean2;
    }

    public CdiRest() {
    }

    @Path("/test1")
    @GET
    public String testCdi() {
        return this.cdiBean1.testMe("osman");
    }

    @Path("/test2")
    @GET
    public String testCdi2() {
        return this.cdiBean2.testMe("osman");
    }

    @Path("/test3")
    @GET
    public String testCdi3() {
        return this.cdiBean3.testMe("osman");
    }

    @Path("/test1a")
    @GET
    public String testCdi4() {
        this.localCount++;
        return "LocalCount : " + this.localCount + " " + this.testor.testMe1("osman");
    }

    @Path("/test2a")
    @GET
    public String testCdi5() {
        return this.testor.testMe2("osman");
    }

    @Path("/test3a")
    @GET
    public String testCdi6() {
        return this.testor.testMe3("osman");
    }

    public MyCdiBean getCdiBean3() {
        return this.cdiBean3;
    }

    // Method Injection
    @Inject
    public void setCdiBean3(final MyCdiBean cdiBean3Param) {
        this.cdiBean3 = cdiBean3Param;
    }

    @PostConstruct
    public void init() {

    }

    @PreDestroy
    public void destroy() {

    }

}
