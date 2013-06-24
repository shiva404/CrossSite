package com.intuit.ctodev.fdp.exp.ContainerFilter;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import javax.ws.rs.core.MultivaluedMap;
import java.util.Hashtable;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 4/25/13
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestResponseFilter implements ContainerResponseFilter {
    private static final Logger logger = Logger.getLogger(TestResponseFilter.class);
    private static final String ORIGIN_HEADER = "origin";
    //Access-Control-Allow-Origin: http://api.bob.com
    private static final String ACCESS_CONTROL_ALLOW_ORIGIN_HEADER = "Access-Control-Allow-Origin";

    @Override
    public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
        Hashtable headers = MDC.getContext();
        response.getHttpHeaders().add(ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "http://localhost:8082");

        MultivaluedMap<String, Object> httpHeaders = response.getHttpHeaders();
        logger.trace("####################---***/ http response headers start /***---####################");
        for (String key : httpHeaders.keySet()){
            logger.trace(key + ": " + httpHeaders.get(key));
        }
        logger.trace("####################---***/ http response headers end /***---####################");
        return response;
    }
}
