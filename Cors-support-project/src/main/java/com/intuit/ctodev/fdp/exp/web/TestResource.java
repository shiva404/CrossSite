package com.intuit.ctodev.fdp.exp.web;

import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 4/24/13
 * Time: 4:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestResource implements ITestResource {
    @Override
    public Response getReq() {
        try {
            return Response.created(new URI("wwww.google.com")).build();  //To change body of implemented methods use File | Settings | File Templates.
        } catch (URISyntaxException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return null;
        }
    }
}
