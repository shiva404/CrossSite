package com.intuit.ctodev.fdp.exp.types;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 6/17/13
 * Time: 4:07 PM
 * To change this template use File | Settings | File Templates.
 */

@XmlRootElement(name = "Something")
@XmlType(name = "Something", propOrder = {"lineOne", "lineTwo", "complexTestType", "complexTestTypeOther", "complexTypeOneMore"})
public class Something implements Serializable {

    private String lineOne;

    private String lineTwo;


    private ComplexTestType complexTestType;

    private ComplexTestTypeOther complexTestTypeOther;

    public ComplexTypeOneMore getComplexTypeOneMore() {
        return complexTypeOneMore;
    }

    public void setComplexTypeOneMore(ComplexTypeOneMore complexTypeOneMore) {
        this.complexTypeOneMore = complexTypeOneMore;
    }

    private ComplexTypeOneMore complexTypeOneMore;

    public ComplexTestTypeOther getComplexTestTypeOther() {
        return complexTestTypeOther;
    }
    @XmlElement
    public void setComplexTestTypeOther(ComplexTestTypeOther complexTestTypeOther) {
        this.complexTestTypeOther = complexTestTypeOther;
    }



    public ComplexTestType getComplexTestType() {
        return complexTestType;
    }
    @XmlElement
    public void setComplexTestType(ComplexTestType complexTestType) {
        this.complexTestType = complexTestType;
    }

    public String getLineOne() {
        return lineOne;
    }

    public void setLineOne(String lineOne) {
        this.lineOne = lineOne;
    }

    public String getLineTwo() {
        return lineTwo;
    }

    public void setLineTwo(String lineTwo) {
        this.lineTwo = lineTwo;
    }

    @Override
    public String toString() {
        return "Something{" +
                "lineOne='" + lineOne + '\'' +
                ", lineTwo='" + lineTwo + '\'' +
                ", complexTestType=" + complexTestType +
                ", complexTestTypeOther=" + complexTestTypeOther +
                ", complexTypeOneMore=" + complexTypeOneMore +
                '}';
    }
}
