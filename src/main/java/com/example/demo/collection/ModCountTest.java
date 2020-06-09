package com.example.demo.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author: chunmu
 * @Date: 2020/6/5 12:57
 * @Description:
 */
public class ModCountTest {

    protected transient int modCount;

    public ModCountTest(int count){
        this.modCount = count;
    }

    public static void main(String[] args){
        // testList();
        testMap();

        // testListFor();

        // ModCountTest test = new ModCountTest(19);
        // A a = test.getA();
        // System.out.println(a);
    }

    private A getA(){
        return new A();
    }


    private static void testMap(){
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        int i = 0;
        for(Map.Entry<String, String> entry : map.entrySet()){
            map.put("e", "e");
            String key = entry.getKey();
            System.out.println("key=" + key);
            System.out.println("next=" + (++i));
            if("c".equals(key)){
                map.put("d", "d");
            }
        }
    }

    private static void testList(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Iterator<String> iterator = list.iterator();
        int i = 0;
        while (iterator.hasNext()){
            String str = iterator.next();
            System.out.println("next=" + (++i));
            // list.remove(str);
            if("d".equals(str)){
                list.add("e");
            }
        }
    }

    private static void testListFor(){
        List<String> list = new ArrayList<>();
        list.add("a");
        for(String str : list){
            list.remove("a");
        }
    }

    private class A {
        int cursor;
        int lastRet = -1;
        int expectedModCount = modCount;

        A(){};
    }

}
