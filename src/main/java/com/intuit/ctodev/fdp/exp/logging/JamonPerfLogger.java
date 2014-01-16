package com.intuit.ctodev.fdp.exp.logging;


import com.jamonapi.FactoryEnabled;
import com.jamonapi.MonKey;
import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactoryInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 7/12/13
 * Time: 11:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class JamonPerfLogger {
    private String apiName;
    private MonitorFactoryInterface factory;

    public MonitorFactoryInterface getFactory() {
        return factory;
    }

    public void setFactory(MonitorFactoryInterface factory) {
        this.factory = factory;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public void startNewPerfLogger(String apiName){
        this.apiName = apiName;
        factory = new FactoryEnabled();
    }

    public void reset(){
        this.apiName = null;
        factory = null;
    }

    public static String getPrintableString(Monitor monitor){
        MonKey monKey = monitor.getMonKey();
        String api = null;
        String jamonKeyString = monKey.toString();
        //JAMon Label=com.intuit.ctodev.fdp.exp.api.ITestResource.getReq, Units=ms.

        String regEx ="JAMon Label=(.*), Units=.*";

        Pattern pattern = Pattern.compile(regEx);

        Matcher matcher = pattern.matcher(jamonKeyString);

        if(matcher.matches()){
            api = matcher.group(1);
        }

        StringBuffer stringBuffer = new StringBuffer(api);
        stringBuffer.append(":" + (int) Math.ceil(monitor.getHits()));
        stringBuffer.append(":" + (int) Math.ceil(monitor.getMin()));
        stringBuffer.append(":" + (int) Math.ceil(monitor.getMax()));
        stringBuffer.append(":" + (int) Math.ceil(monitor.getAvg()));
        stringBuffer.append(":" + (int) Math.ceil(monitor.getTotal()));

        return stringBuffer.toString();
    }

    public static JamonPerfLogger getPerfLoger(){
        return PERF_LOGGER_THREAD_LOCAL.get();
    }

    private static final ThreadLocal<JamonPerfLogger> PERF_LOGGER_THREAD_LOCAL = new ThreadLocal<JamonPerfLogger>(){
        @Override
        protected JamonPerfLogger initialValue() {
            JamonPerfLogger perfLogger = new JamonPerfLogger();
            return perfLogger;
        }
    };

}
