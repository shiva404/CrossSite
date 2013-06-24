package com.intuit.test.commons;

import com.sun.jersey.api.client.WebResource;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 5/21/13
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestBase {
    public static WebResource resource;

    static{
        ResourceProvider  provider = new ResourceProvider();


        resource = provider.getResource();

    }
}
