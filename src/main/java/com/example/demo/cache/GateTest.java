package com.example.demo.cache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: chunmu
 * @Date: 2019/11/19 21:03
 * @Description:
 */
public class GateTest {

    public static void main(String[] args){
        Map<String, String> map1 = new HashMap<>();
        map1.put("c", "c");
        map1.put("b", "b");
        map1.put("d", "d");

        for(Map.Entry<String, String> entry : map1.entrySet()){
            System.out.println(entry.getKey());
        }


        Map<String, String> map2 = new LinkedHashMap<>();
        map2.put("c", "c");
        map2.put("b", "b");
        map2.put("d", "d");

        for(Map.Entry<String, String> entry : map2.entrySet()){
            System.out.println(entry.getKey());
        }
    }



}
