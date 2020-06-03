package com.example.demo.singleton;

/**
 * @author: chunmu
 * @Date: 2020/5/22 10:40
 * @Description: 饿汉 + 线程安全
 */
public class Singleton1 {

    public static final Singleton1 instance = new Singleton1();

    private Singleton1(){};

    public static Singleton1 getInstance(){
        return instance;
    }

}
