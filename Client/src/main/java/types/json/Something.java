package types.json;


import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 6/17/13
 * Time: 4:07 PM
 * To change this template use File | Settings | File Templates.
 */

public class Something implements Serializable {

    private String lineOne;

    private String lineTwo;


    private ComplexTestType complexTestType;

//    private Object any;
//    public Object getAny() {
//        return any;
//    }
//
////    @XmlAnyElement
//    public void setAny(Object any) {
//        this.any = any;
//    }

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
                ", other=" + other +
                '}';
    }
}
