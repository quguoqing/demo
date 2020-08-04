package com.example.demo.spring;

/**
 * @author: chunmu
 * @Date: 2020/6/16 18:10
 * @Description:
 */
public class C extends A {

    public C(){
        // super();
        System.out.println("C class init");
    }

    public static void main(String[] args){
        C c = new C();
        System.out.println("c.a=" + c.a);
    }

}
