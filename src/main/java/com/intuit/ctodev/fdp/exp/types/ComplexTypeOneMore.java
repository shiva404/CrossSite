package com.intuit.ctodev.fdp.exp.types;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 6/18/13
 * Time: 2:56 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlType(name = "ComplexTypeOneMore", propOrder = {"lineOne", "lineTwo", "innerComplexClass"})
public class ComplexTypeOneMore {

    private String lineOne;
    private String lineTwo;
    private InnerComplexClass innerComplexClass;

    public ComplexTypeOneMore() {
    }

    public InnerComplexClass getInnerComplexClass() {
        return innerComplexClass;
    }

    public void setInnerComplexClass(InnerComplexClass innerComplexClass) {
        this.innerComplexClass = innerComplexClass;
    }

    public ComplexTypeOneMore(String lineOne, String lineTwo, InnerComplexClass innerComplexClass) {
        this.lineOne = lineOne;
        this.lineTwo = lineTwo;
        this.innerComplexClass = innerComplexClass;
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


    @Override
    public String toString() {
        return "ComplexTypeOneMore{" +
                "lineOne='" + lineOne + '\'' +
                ", lineTwo='" + lineTwo + '\'' +
                ", innerComplexClass=" + innerComplexClass +
                '}';
    }
}
