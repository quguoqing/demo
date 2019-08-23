package com.example.demo.encode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: chunmu
 * @Date: 2019/8/23 09:53
 * @Description:
 */
public class MyMap {

    public static void main1(String[] args){
        Map<String, String> myMap = new HashMap<>(16);
        myMap.put("1", "1");
        myMap.put("1", "2");
        myMap.put("1", "3");
        myMap.put("1", "4");

        for(Map.Entry<String, String> entry : myMap.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();

            System.out.println("key=" + key + ";value=" + value);
        }
    }

    public static void main(String[] args){
        Map<String, String> myMap = new MyCacheHashMap(2, true);

        myMap.put("1", "1");
        myMap.put("2", "2");
        myMap.put("3", "3");

        myMap.get("1");
        myMap.get("2");


        for(Map.Entry<String, String> entry : myMap.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();

            System.out.println("key=" + key + ";value=" + value);
        }
    }


}
