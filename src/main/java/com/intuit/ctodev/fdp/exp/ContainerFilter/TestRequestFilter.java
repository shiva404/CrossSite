package com.intuit.ctodev.fdp.exp.ContainerFilter;

import com.intuit.ctodev.fdp.exp.logging.JamonPerfLogger;
import com.intuit.ctodev.fdp.exp.logging.PerfLogHolder;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.MultivaluedMap;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 4/25/13
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestRequestFilter implements ContainerRequestFilter {

    private static final String DEBUG_HEADER = "debug";

    private static final Logger logger = Logger.getLogger(TestRequestFilter.class);
    @Override
    public ContainerRequest filter(ContainerRequest request) {
        PerfLogHolder perfLogHolder = PerfLogHolder.getPerfLogHolder();
        perfLogHolder.start(request.getPath());

        logger.trace("adding to the thread local ------ >" + perfLogHolder.hashCode());
        MultivaluedMap<String, String> headers = request.getRequestHeaders();

        for (String string : headers.keySet()) {
            MDC.put(string, headers.get(string));
        }
        return request;
    }

    private boolean isDebugHeaderSet(MultivaluedMap<String, String> headers){
        if(headers.get(DEBUG_HEADER) != null && Boolean.getBoolean(headers.getFirst(DEBUG_HEADER))){
            return true;
        }
        return false;

    }
}
