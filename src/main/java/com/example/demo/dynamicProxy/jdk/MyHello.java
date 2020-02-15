package com.example.demo.dynamicProxy.jdk;

/**
 * @author: chunmu
 * @Date: 2020/2/14 21:26
 * @Description:
 */
public class MyHello implements IHello {

    @Override
    public void hello(String name) {
        System.out.println("hello " + name);
    }
}
