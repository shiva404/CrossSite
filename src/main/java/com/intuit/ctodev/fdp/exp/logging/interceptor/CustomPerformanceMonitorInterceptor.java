package com.intuit.ctodev.fdp.exp.logging.interceptor;

import com.intuit.ctodev.fdp.exp.logging.PerfLogHolder;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 7/9/13
 * Time: 12:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomPerformanceMonitorInterceptor extends PerformanceMonitorInterceptor {



    @Override
    protected Object invokeUnderTrace(MethodInvocation invocation, Log logger) throws Throwable {
        PerfLogHolder perfLogHolder = PerfLogHolder.getPerfLogHolder();
        logger.trace("got here");
        String name = createInvocationTraceName(invocation);
        StopWatch stopWatch = new StopWatch(name);
        stopWatch.start(name);
        try {
            return invocation.proceed();
        }
        finally {
            stopWatch.stop();
           // perfLogHolder.getStopWatches().add(stopWatch);
        }
    }

}
