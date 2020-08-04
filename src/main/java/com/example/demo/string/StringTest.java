package com.example.demo.string;

/**
 * @author: chunmu
 * @Date: 2020/7/5 22:54
 * @Description:
 */
public class StringTest {


    public static void main(String[] arg){
        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = s1.intern();
        String s4 = s2.intern();
        System.out.println(s1 == s2); //false
        System.out.println(s1 == s3); //true
        System.out.println(s2 == s3); //false
        System.out.println(s2 == s4); //false
        System.out.println(s3 == s4); //true


        // String s1 = new StringBuilder("abc").toString();
        // System.out.println(s1 == s1.intern()); // false

        // String s1 = new StringBuilder("ab").append("c").toString();
        // System.out.println(s1 == s1.intern()); //true

        // String s1 = new StringBuilder("ja").append("va").toString();
        // System.out.println(s1 == s1.intern()); //false。java保留字段，它肯定已经很早就在字符串常量池里面了




    }

}
