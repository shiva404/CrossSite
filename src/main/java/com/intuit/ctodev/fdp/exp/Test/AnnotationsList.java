package com.intuit.ctodev.fdp.exp.Test;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

import javax.ws.rs.*;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 10/29/13
 * Time: 12:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class AnnotationsList {

    static private Reflections ref = null;

    public static void main(String args[]){
        ref = new Reflections("com.intuit.ctodev.fdp.exp.api",
                new MethodAnnotationsScanner());
        Set<Method> methods = getHttpMethodAnnotatedMethods();
        for (Method method : methods){
            System.out.println(method.toString());
        }
    }

    public static Set<Method> getHttpMethodAnnotatedMethods(){
        Set<Method> methods = ref.getMethodsAnnotatedWith(GET.class);
        methods.addAll(ref.getMethodsAnnotatedWith(PUT.class));
        methods.addAll(ref.getMethodsAnnotatedWith(POST.class));
        methods.addAll(ref.getMethodsAnnotatedWith(DELETE.class));

        return methods;
    }
}
