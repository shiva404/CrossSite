package com.intuit.ctodev.fdp.exp.util;

import com.intuit.ctodev.fdp.exp.types.*;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 6/17/13
 * Time: 4:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class ObjectCreator {

    public static Something getSomethingObject(){
        Something something = new Something();

        something.setLineOne("lineOne");
        something.setLineTwo("lineTwo");

        something.setComplexTestType(new ComplexTestType("lineOne", "lineTwo"));
        something.setComplexTestTypeOther(new ComplexTestTypeOther("lineOne", "lineTwo", new InnerComplexClass("innerLine1", "innerLine2")));
        something.setComplexTypeOneMore(new ComplexTypeOneMore("oneMoreLine1", "oneMoreLine2", new InnerComplexClass("innerLine1", "innerLine2")));
        return something;
    }
}
