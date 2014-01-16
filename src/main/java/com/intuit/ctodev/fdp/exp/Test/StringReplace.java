package com.intuit.ctodev.fdp.exp.Test;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 8/9/13
 * Time: 9:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class StringReplace {
    public static void main(String[] args){
        String s = "gw-9d6b7004-2c53-4f56-b8d0-dd168cf894cc";

        System.out.println(s.replace("gw-", ""));
        System.out.println(s.replace("adadada", ""));
    }
}
