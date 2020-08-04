package com.example.demo.string;

/**
 * @author: chunmu
 * @Date: 2020/7/5 23:31
 * @Description:
 */
public class StringTest1 {

    public static void main(String[] args){
        // String s = "a" + "b" + "c";
        //
        // String a = "a";
        // String b = "b";
        // String c = "c";
        //
        // String s1 = a + b + c;
        //
        // System.out.println(s == s1); //false
        // System.out.println(s == s1.intern()); //true


        // test3();
        test4();


    }

    private static void test1(){
        String s1 = new String("abc");
        String s2 = new String("abc");
        String s3 = s1.intern();
        String s4 = s2.intern();

        System.out.println(s1 == s2); //false
        //字面量有"abc"，所以一开始字符串常量池就有值
        System.out.println(s3 == s4); //true
        System.out.println(s1 == s3); //false
        System.out.println(s2 == s4); //false
        System.out.println(s1 == s4); //false
    }

    private static void test2(){
        String s1 = new String("ab") + new String("c");
        String s2 = new String("ab") + new String("c");
        String s3 = s1.intern();
        String s4 = s2.intern();

        System.out.println(s1 == s2); //false
        //s1先执行intern，会先把常量池中放入s1的地址，然后s2在执行intern的话，直接返回常量池的abc地址
        System.out.println(s3 == s4); //true
        System.out.println(s1 == s3); //true
        System.out.println(s2 == s4); //false
        System.out.println(s1 == s4); //true
    }

    private static void test3(){
        String s1 = new String("a") + new String("b");
        String s2 = s1.intern();
        String s3 = "ab";

        System.out.println(s1 = s2); //true
        System.out.println(s1 == s3); //true


    }

    private static void test4(){
        String s3 = "ab";
        String s1 = new String("a") + new String("b");
        String s2 = s1.intern();


        System.out.println(s1 == s2); //false
        System.out.println(s1 == s3); //false


    }

}
