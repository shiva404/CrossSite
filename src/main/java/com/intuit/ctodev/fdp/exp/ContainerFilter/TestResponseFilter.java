package com.intuit.ctodev.fdp.exp.ContainerFilter;

import com.intuit.ctodev.fdp.exp.logging.JamonPerfLogger;
import com.intuit.ctodev.fdp.exp.logging.PerfLogHolder;
import com.jamonapi.Monitor;
import com.jamonapi.MonitorComposite;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;

import javax.ws.rs.core.MultivaluedMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
        PerfLogHolder perfLogHolder = PerfLogHolder.getPerfLogHolder();
        perfLogHolder.stop();

        String perfLogString = String.format( "%1$s freeMem=[%2$d mb] totalMem=[%3$d mb]", perfLogHolder.getSummaryString(),
                (Runtime.getRuntime().freeMemory()/1000000L), (Runtime.getRuntime().maxMemory()/1000000L));
        logger.info(perfLogString);

        perfLogHolder.reset();

        return response;

    }
}
