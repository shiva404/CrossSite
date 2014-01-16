package com.intuit.ctodev.fdp.exp.logger;

import com.intuit.ctodev.fdp.exp.logging.JamonPerfLogger;
import com.intuit.ctodev.fdp.exp.logging.PerfLogHolder;
import com.jamonapi.Monitor;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import javax.annotation.concurrent.ThreadSafe;
import java.lang.reflect.Method;


/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 1/6/14
 * Time: 12:18 PM
 * To change this template use File | Settings | File Templates.
 */
@Aspect
@ThreadSafe
public class TimerAdvice {
    private static final Logger logger = Logger.getLogger(TimerAdvice.class);

    @Around(value = "@annotation(timingAnnotation)", argNames = "pjp,timingAnnotation")
    public Object doTiming(ProceedingJoinPoint pjp,
                           TimingMonitor timingAnnotation) throws Throwable {
        PerfLogHolder perfLogger = PerfLogHolder.getPerfLogHolder();
        logger.trace("getting to the thread local ******** >" + perfLogger.hashCode());
        String name = createInvocationTraceName(pjp);
        Monitor monitor = perfLogger.getFactory().start(name);
        try {
            return pjp.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        } finally {
            monitor.stop();
        }
    }

    protected String createInvocationTraceName(ProceedingJoinPoint joinPoint) {
        StringBuffer sb = new StringBuffer("");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Class clazz = method.getDeclaringClass();
        sb.append(clazz.getSimpleName());
        sb.append('.').append(method.getName());
        return sb.toString();
    }

}
