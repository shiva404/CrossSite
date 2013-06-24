package com.intuit.test;

import com.intuit.test.commons.TestBase;
import com.intuit.test.types.json.Something;
import com.sun.jersey.api.client.ClientResponse;
import org.testng.annotations.Test;

import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 6/18/13
 * Time: 12:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class ResourceTypeJSON extends TestBase {

    Something somethingJson;


    @Test
    public void testGetJson(){

        ClientResponse clientResponse = resource.path("/test/get").accept(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);
        somethingJson = clientResponse.getEntity(Something.class);
    }


    @Test(dependsOnMethods = "testGetJson")
    public void testPostJson(){
        System.out.println("inside json post" + somethingJson);
        resource.path("/test/post").type(MediaType.APPLICATION_JSON_TYPE).entity(somethingJson).post();
    }
}
