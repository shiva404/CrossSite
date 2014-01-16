package com.intuit.ctodev.fdp.exp.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 7/12/13
 * Time: 4:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegExExample {

    public static void main( String args[] ){

        // String to be scanned to find the pattern.
        String line = "JAMon Label=com.intuit.ctodev.fdp.exp.api.ITestResource.getReq, Units=ms.";
        String pattern = "JAMon Label=(.*), Units=.*";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(1) );

        } else {
            System.out.println("NO MATCH");
        }







        line = "sourceData/thumbnail";
        String line2 = "/thumbnail";

        pattern = "sourceData|^$/thumbnail";

        r = Pattern.compile(pattern);

        // Now create matcher object.
        m = r.matcher(line);




        line = "";

        pattern = "^$";

        r = Pattern.compile(pattern);

        // Now create matcher object.
        m = r.matcher(line);

        if (m.find( )) {
            System.out.println("Found value empty line: " + m.group(0) );

        } else {
            System.out.println("Found value empty line: NO MATCH");
        }




        if (m.find( )) {
            System.out.println("Found value line 1: " + m.group(0) );

        } else {
            System.out.println("NO MATCH");
        }

        m = r.matcher(line2);
        if (m.find( )) {
            System.out.println("Found value line 2: " + m.group(0) );

        } else {
            System.out.println("NO MATCH");
        }




    }

}
