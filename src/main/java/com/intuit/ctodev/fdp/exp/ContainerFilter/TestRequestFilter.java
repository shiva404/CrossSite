package com.intuit.ctodev.fdp.exp.ContainerFilter;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import javax.ws.rs.core.MultivaluedMap;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 4/25/13
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestRequestFilter implements ContainerRequestFilter {
    private static final Logger logger = Logger.getLogger(TestRequestFilter.class);
    @Override
    public ContainerRequest filter(ContainerRequest request) {
        MultivaluedMap<String, String> headers = request.getRequestHeaders();
        logger.trace("----------------------------***/ http request headers start/***----------------------------");
        for (String string : headers.keySet()) {
            MDC.put(string, headers.get(string));

            logger.trace(string + ": " + headers.get(string));


        }
        logger.trace("----------------------------***/ http request headers end/***----------------------------");
        return request;
    }
}
