package com.intuit.ctodev.fdp.exp.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 11/8/13
 * Time: 7:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class ListTest {
    public static int MAX_LIST_LIMIT = 100;
    public static void main(String[] args){

        List<String> documentEntityTypes = new ArrayList<String>();
        for (int i = 0 ; i<250; i++){
            documentEntityTypes.add("abc --" + i);

        }


        ListTest listTest = new ListTest();
        List<String> strings = listTest.getSourceEntities(documentEntityTypes);

    }

    private List<String> getSourceEntities(List<String> entityKeys){
        if(entityKeys != null && entityKeys.size() != 0){
            Map<String, String> sourceKeySizeMap = new HashMap<String, String>(entityKeys.size());
            int iteration = 1;
            do{
                int fromIndex = (iteration - 1) * MAX_LIST_LIMIT;
                int toIndex = entityKeys.size() - MAX_LIST_LIMIT * iteration > 0 ? MAX_LIST_LIMIT * iteration - 1 : entityKeys.size();
                System.out.println("from -- " + fromIndex + "  to -- " + toIndex);
                iteration ++;
            } while(entityKeys.size() - MAX_LIST_LIMIT * (iteration - 1) > 0);
        }

        return null;
    }
}
