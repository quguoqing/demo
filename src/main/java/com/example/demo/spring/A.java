package com.example.demo.spring;

import org.springframework.stereotype.Component;

/**
 * @author: chunmu
 * @Date: 2020/5/19 23:15
 * @Description:
 */

public class A {

    public Integer a = 0;

    public A(){
        a = 1;
        System.out.println("A class init");
    }

}
