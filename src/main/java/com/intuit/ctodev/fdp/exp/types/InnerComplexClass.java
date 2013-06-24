package com.intuit.ctodev.fdp.exp.types;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 6/18/13
 * Time: 3:06 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlType(name = "InnerComplexClass", propOrder = {"lineOne", "lineTwo"})
public class InnerComplexClass {
    private String lineOne;
    private String lineTwo;

    @Override
    public String toString() {
        return "InnerComplexClass{" +
                "lineOne='" + lineOne + '\'' +
                ", lineTwo='" + lineTwo + '\'' +
                '}';
    }

    public InnerComplexClass(String lineOne, String lineTwo) {
        this.lineOne = lineOne;
        this.lineTwo = lineTwo;
    }

    public InnerComplexClass() {
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

}
