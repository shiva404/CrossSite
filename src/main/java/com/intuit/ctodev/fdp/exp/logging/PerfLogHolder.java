package com.intuit.ctodev.fdp.exp.logging;

import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 7/9/13
 * Time: 11:53 AM
 * To change this template use File | Settings | File Templates.
 */
import com.jamonapi.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PerfLogHolder {


    private String apiName;
    private MonitorFactoryInterface factory;
    private Long startTime;
    private Long endTime;
    private boolean running;
    public static final String REG_EX_JAMON_LABEL = "JAMon Label=(.*), Units=.*";

    private PerfLogHolder(){

    }

    public String getApiName() {
        return apiName;
    }

    public MonitorFactoryInterface getFactory() {
        return factory;
    }


    public void start(String apiName){
        running = true;
        this.apiName = apiName;
        factory = new FactoryEnabled();
        startTime = System.currentTimeMillis();
    }

    public void stop(){
        if(!running){
            throw new IllegalStateException("Perf logger no started.");
        }
        running = false;
        endTime = System.currentTimeMillis();
    }

    public Long getTotalExecutionTime(){
        if(running){
            throw new IllegalStateException("Perf logger no yet stopped.");
        }
        return endTime - startTime;
    }

    public void reset(){
        this.apiName = null;
        startTime = endTime = 0L;
        running = false;
        factory = null;
    }

    public String getSummaryString(){
        if(running){
            throw new IllegalStateException("Perf logger no yet stopped.");
        }

        MonitorComposite monitorComposite = factory.getRootMonitor();
        Monitor[] monitors = monitorComposite.getMonitors();
        String apiNameWithExecTime = String.format("[%1$s] - %2$d - ", apiName, getTotalExecutionTime());
        StringBuffer stringBuffer = new StringBuffer(apiNameWithExecTime);

        if(monitors != null){
            for (Monitor monitor : monitors){
                MonKey monKey = monitor.getMonKey();
                String api = null;
                String jamonKeyString = monKey.toString();

                Pattern pattern = Pattern.compile(REG_EX_JAMON_LABEL);

                Matcher matcher = pattern.matcher(jamonKeyString);

                if(matcher.matches()){
                    api = matcher.group(1);
                }

                stringBuffer.append(api);
                stringBuffer.append(":" + (int) Math.ceil(monitor.getHits()));
                stringBuffer.append(":" + (int) Math.ceil(monitor.getMin()));
                stringBuffer.append(":" + (int) Math.ceil(monitor.getMax()));
                stringBuffer.append(":" + (int) Math.ceil(monitor.getAvg()));
                //  stringBuffer.append(":" + (int) Math.ceil(monitor.getTotal()));    //removing total
                stringBuffer.append(" ");
            }
        }

        return stringBuffer.toString();
    }


    public static PerfLogHolder getPerfLogHolder(){
        return PERF_LOG_HOLDER_THREAD_LOCAL.get();
    }

    private static final ThreadLocal<PerfLogHolder> PERF_LOG_HOLDER_THREAD_LOCAL = new ThreadLocal<PerfLogHolder>(){
        @Override
        protected PerfLogHolder initialValue() {
            PerfLogHolder perfLogger = new PerfLogHolder();
            return perfLogger;
        }
    };
}
