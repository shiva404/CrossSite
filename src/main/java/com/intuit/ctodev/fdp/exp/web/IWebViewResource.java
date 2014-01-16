package com.intuit.ctodev.fdp.exp.web;

import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 4/24/13
 * Time: 2:07 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/web")
public interface IWebViewResource {
    @GET
    @Produces("text/html")
    public Response index();


    @PUT
    @Path("/stream")
    @Consumes("*/*")
    public Response fileUploadStream(@Context Request request, InputStream file);

    @GET
    @Produces("text/html")
    @Path("/hello")
    public Response hello();


    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("/multipart")
    public Response uploadFile();

}
