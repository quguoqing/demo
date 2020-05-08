package com.example.demo.cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: chunmu
 * @Date: 2020/4/13 19:18
 * @Description:
 */
public class IntegerTest {

    public static void main(String[] args){
        Integer i1 = 100;
        Integer i2 = new Integer(100);
        System.out.println(i1 == i2);


        int i3 = 100;
        Integer i4 = new Integer(100);
        System.out.println(i3 == i4);

        String a = "abc";
        String b = a.intern();
        // System.out.println("a=" + a + ";b=" + b);
        System.out.println(a == b);
        String a2 = "a" + "b" + "c";
        System.out.println("a=a2 = " + (a == a2));

        String a3 = "a" + new String("b") + "c";
        System.out.println("a=a3 = " + (a == a3));

        String c = "cde";
        String c1 = "cde";
        String d = new String("cde");
        // System.out.println("c=" + c + ";d=" + d);
        System.out.println("c==c1 = " + (c == c1));
        System.out.println(c == d);

        List<String> list = Arrays.asList("a", "b", "c");
        for(String str : list){
            System.out.println(str);
        }

    }

}
