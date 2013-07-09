package com.intuit.ctodev.fdp.exp.web;

import com.sun.jersey.api.view.Viewable;

import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 4/24/13
 * Time: 2:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class WebViewResource implements IWebViewResource {

    @Override
    public Response index() {
        return Response.ok(new Viewable("/index.jsp")).build();
    }
}
