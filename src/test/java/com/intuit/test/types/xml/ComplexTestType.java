package com.intuit.test.types.xml;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 6/17/13
 * Time: 4:10 PM
 * To change this template use File | Settings | File Templates.
 */

@XmlRootElement(name = "ComplexTestType")
@XmlType(name = "ComplexTestType", propOrder = {"lineOne", "lineTwo"})
public class ComplexTestType {

    private String lineOne;

    public ComplexTestType() {
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

    private String lineTwo;

    public ComplexTestType(String lineOne, String lineTwo) {
        this.lineOne = lineOne;
        this.lineTwo = lineTwo;
    }


    @Override
    public String toString() {
        return "ComplexTestType{" +
                "lineOne='" + lineOne + '\'' +
                ", lineTwo='" + lineTwo + '\'' +
                '}';
    }
}
