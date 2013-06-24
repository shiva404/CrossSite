package com.intuit.ctodev.fdp.exp.types;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 6/17/13
 * Time: 4:20 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlType(name = "ComplexTestTypeOther", propOrder = {"lineOne", "lineTwo", "innerComplexClass"})
public class ComplexTestTypeOther {
    private String lineOne;
    private String lineTwo;
    private InnerComplexClass innerComplexClass;

    public InnerComplexClass getInnerComplexClass() {
        return innerComplexClass;
    }

    public void setInnerComplexClass(InnerComplexClass innerComplexClass) {
        this.innerComplexClass = innerComplexClass;
    }


    public ComplexTestTypeOther() {
    }

    public String getLineTwo() {
        return lineTwo;
    }

    public void setLineTwo(String lineTwo) {
        this.lineTwo = lineTwo;
    }

    public String getLineOne() {
        return lineOne;
    }

    public void setLineOne(String lineOne) {
        this.lineOne = lineOne;
    }



    public ComplexTestTypeOther(String lineOne, String lineTwo, InnerComplexClass innerComplexClass) {
        this.lineOne = lineOne;
        this.lineTwo = lineTwo;
        this.innerComplexClass = innerComplexClass;
    }

    @Override
    public String toString() {
        return "ComplexTestTypeOther{" +
                "lineOne='" + lineOne + '\'' +
                ", lineTwo='" + lineTwo + '\'' +
                '}';
    }
}
