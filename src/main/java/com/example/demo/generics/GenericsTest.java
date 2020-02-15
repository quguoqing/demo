package com.example.demo.generics;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: chunmu
 * @Date: 2020/2/14 23:36
 * @Description:
 */
public class GenericsTest {

    public static void main(String[] args){
        Map<String, String> map1 = new HashMap<>();
        map1.put("1", "1");
        Object str1 = map1.get("1");
        Map<Integer, Integer> map2 = new HashMap<>();
        map2.put(1, 1);
        Object str2 = map2.get(1);
    }

}
