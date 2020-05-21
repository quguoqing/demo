package com.example.demo.switchtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: chunmu
 * @Date: 2020/5/20 11:32
 * @Description:
 */
public class GenericTest {

    public static void main(String[] args){
        String[] keys = new String[]{"1", "2"};
        String[] values = new String[]{"a", "b"};

        Map<String, String> result = newHashMap(keys, values);
        System.out.println(result.toString());

        List<String> list1 = getStringList();
        List<Integer> list2 = getIntegerList();
        System.out.println(list1.toString());
        System.out.println(list2.toString());

    }

    private static List<String> getStringList(){
        return null;
    }

    private static List<Integer> getIntegerList(){
        return null;
    }

    /**
     * 泛型方法定义
     * @param keys
     * @param values
     * @param <K>
     * @param <V>
     * @return
     */
    private static <K,V> Map<K,V> newHashMap(K[] keys, V[] values){
        //检查参数
        if(keys.length == 0 || values.length == 0){
            return Collections.emptyMap();
        }
        // 转化哈希映射
        Map<K, V> map = new HashMap<>();
        int length = Math.min(keys.length, values.length);
        for (int i = 0; i < length; i++) {
            map.put(keys[i], values[i]);
        }
        return map;
    }

    /**
     * 和上面的方法比较，这个方法就不通用。
     * @param keys
     * @param values
     * @return
     */
    // private static Map<String, Object> newHashMap(String[] keys, Object[] values){
    //     //todo
    //     return null;
    // }

}
