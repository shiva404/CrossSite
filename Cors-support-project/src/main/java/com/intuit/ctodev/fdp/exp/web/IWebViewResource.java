package com.intuit.ctodev.fdp.exp.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

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


}
