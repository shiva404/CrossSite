/**
 * 
 */
package com.intuit.test.commons;

import com.sun.jersey.api.json.JSONConfiguration;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;


/**
 * @author Shivakumar N
 *
 * @since Jun 22, 2012 10:04:53 AM
 */

public class ResourceProvider extends JerseyTest{
	
	private static final AppDescriptor APP_DESCRIPTOR =
		new WebAppDescriptor.Builder("com.intuit.platform.integration.sdx.ws.beans")
    .contextParam("contextConfigLocation", "classpath:glassfish-web.xml")
    .servletClass(SpringServlet.class)
    .contextListenerClass(ContextLoaderListener.class)
    .requestListenerClass(RequestContextListener.class)
   // .initParam("com.sun.jersey.spi.container.ContainerRequestFilters", "com.intuit.platform.integration.sdx.ws.requestFilters.SDXRequestFilter")
   // .initParam("com.sun.jersey.spi.container.ContainerResponseFilters", "com.intuit.platform.integration.sdx.ws.requestFilters.SDXResponseFilter")
    .initParam("com.sun.jersey.spi.container.ContainerRequestFilters", "com.sun.jersey.api.container.filter.LoggingFilter")
    .initParam("com.sun.jersey.spi.container.ContainerResponseFilters", "com.sun.jersey.api.container.filter.LoggingFilter")
    .initParam("com.sun.jersey.api.json.POJOMappingFeature","true")
    .build();
	
	public ResourceProvider() {
		 super(APP_DESCRIPTOR);
	}
	
	public WebResource getResource() {
        client().getProperties().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		return resource();
	}
	
	  @BeforeSuite
	  public void initTestContainer() throws Exception {
	    setUp();
	  }
	
	  @AfterSuite
	  public void tearDownTestContainer() throws Exception {
	    tearDown();
	  }
}
