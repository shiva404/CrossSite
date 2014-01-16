package com.intuit.test;

import com.intuit.test.commons.TestBase;
import com.intuit.test.types.xml.Something;
import com.sun.jersey.api.client.ClientResponse;
import org.testng.annotations.Test;

import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 6/18/13
 * Time: 9:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class ResourceTestXML extends TestBase {
    Something somethingXML;


    @Test
    public void testGetXML(){
        somethingXML = resource.path("/test/get").accept(MediaType.APPLICATION_XML_TYPE).get(Something.class);
        System.out.println(somethingXML);
    }


    @Test(dependsOnMethods = "testGetXML")
    public void testPostXML(){
        resource.path("/test/post").accept(MediaType.APPLICATION_XML_TYPE).entity(somethingXML).post();
    }

    @Test
    public void testMultiPath(){
        resource.path("/test/sourceData/thumbnail").get(ClientResponse.class);
    }

    @Test
    public void testMultiPath2(){
        resource.path("/test/thumbnail").get(ClientResponse.class);
    }

    @Test
    public void testMultiPath3(){
        resource.path("/path/test/thumbnail").get(ClientResponse.class);
    }


}
