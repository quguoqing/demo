package com.example.demo;

import java.io.IOException;

/**
 * @author: chunmu
 * @Date: 2020/7/3 18:22
 * @Description:
 */
public class SimpleHelloworld {

    private static int a = 10000;

    private static long b = 2L;

    private volatile String c = "abc";

    public static void main(String[] args){
        SimpleHelloworld simpleHelloworld = new SimpleHelloworld();
        System.out.println(simpleHelloworld.c);

        try {
            Runtime.getRuntime().exec("rm /Users/quguoqing/Documents/abc");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void test(String a, int b){
        SimpleHelloworld simpleHelloworld = new SimpleHelloworld();
        System.out.println(simpleHelloworld.c);
    }

}
