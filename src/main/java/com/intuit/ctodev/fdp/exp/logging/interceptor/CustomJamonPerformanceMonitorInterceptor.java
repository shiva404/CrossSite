package com.intuit.ctodev.fdp.exp.logging.interceptor;

import com.intuit.ctodev.fdp.exp.logging.JamonPerfLogger;
import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.springframework.aop.interceptor.JamonPerformanceMonitorInterceptor;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 7/12/13
 * Time: 2:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomJamonPerformanceMonitorInterceptor extends JamonPerformanceMonitorInterceptor {

    @Override
    protected Object invokeUnderTrace(MethodInvocation invocation, Log logger) throws Throwable {
        JamonPerfLogger perfLogger = JamonPerfLogger.getPerfLoger();
        String name = createInvocationTraceName(invocation);
        Monitor monitor = perfLogger.getFactory().start(name);
        try {
            return invocation.proceed();
        }
        finally {
            monitor.stop();
        }
    }

    @Override
    protected String createInvocationTraceName(MethodInvocation invocation) {
        StringBuffer sb = new StringBuffer(getPrefix());
        Method method = invocation.getMethod();
        Class clazz = method.getDeclaringClass();
        sb.append(clazz.getSimpleName());
        sb.append('.').append(method.getName());
        sb.append(getSuffix());
        return sb.toString();
    }
}
