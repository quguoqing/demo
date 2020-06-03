package com.example.demo.singleton;

/**
 * @author: chunmu
 * @Date: 2020/5/22 10:42
 * @Description: 懒汉 + 同步锁
 */
public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2(){};

    public static synchronized Singleton2 getInstance(){
        if(null != instance){
            return instance;
        }
        return new Singleton2();
    }

}
