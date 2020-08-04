package com.example.demo.juc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: chunmu
 * @Date: 2020/6/17 10:40
 * @Description:
 */
public class CurrentHashMapEndlessLoopTest {

    public static void main(String[] args){
        System.out.println("方法开始");
        Map<String, Integer> map = new ConcurrentHashMap<>(16);
        map.computeIfAbsent("AaAa", key -> {
            return map.computeIfAbsent("BBBB", key2 -> 42);
        }
        );
        System.out.println("方法结束 map=" + map);
    }
}
