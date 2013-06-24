package com.intuit.test.types.xml;


import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 6/17/13
 * Time: 4:07 PM
 * To change this template use File | Settings | File Templates.
 */

@XmlRootElement(name = "Something")
@XmlType(name = "Something", propOrder = {"lineOne", "lineTwo", "complexTestType", "any"})
public class Something implements Serializable {

    private String lineOne;

    private String lineTwo;


    private ComplexTestType complexTestType;

    @XmlAnyElement
    private List<Object> any;

    public Object getAny() {
        return any;
    }


    public void setAny(List any) {
        this.any = any;
    }

    private Map<String,Object> other = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String,Object> any() {
        return other;
    }

    @JsonAnySetter
    public void set(String name, Object value) {
        other.put(name, value);
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


}
