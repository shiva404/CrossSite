package com.intuit.ctodev.fdp.exp.web;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 4/24/13
 * Time: 4:03 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/test")
public interface ITestResource {
    @GET
    @Path("/get")
    public Response getReq();
}
