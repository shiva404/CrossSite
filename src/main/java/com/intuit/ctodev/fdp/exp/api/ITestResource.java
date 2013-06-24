package com.intuit.ctodev.fdp.exp.api;

import com.intuit.ctodev.fdp.exp.types.Something;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 4/24/13
 * Time: 4:03 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/test")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public interface ITestResource {
    @GET
    @Path("/get")
    public Response getReq();

    @POST
    @Path("/post")
    public Response postReq(Something something);
}
