package com.intuit.ctodev.fdp.exp.api;

import com.intuit.ctodev.fdp.exp.types.Something;
import com.intuit.ctodev.fdp.exp.util.ObjectCreator;

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
        return Response.ok(ObjectCreator.getSomethingObject()).build();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Response postReq(Something something) {
        try {
            System.out.println("boss i am here : -- >" + something);
            return Response.created(new URI("/test/get")).build();
        } catch (URISyntaxException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }
}