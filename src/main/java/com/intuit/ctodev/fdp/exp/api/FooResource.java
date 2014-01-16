package com.intuit.ctodev.fdp.exp.api;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("foo")
public class FooResource {
    @PathParam("id") @DefaultValue("baz") String id;

    @GET
    public String getFoo() {
        return id;
    }

    @GET
    @Path("bar/{id}")
    public String getBar() {
        return id;
    }
}