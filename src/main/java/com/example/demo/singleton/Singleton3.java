package com.example.demo.singleton;

/**
 * @author: chunmu
 * @Date: 2020/5/22 10:50
 * @Description:静态内部类 = 懒加载 + 线程安全
 */
public class Singleton3 {

    private Singleton3(){};

    public static Singleton3 getInstance(){
        return SingletonHolder.instance;
    }


    private static class SingletonHolder {
        private static Singleton3 instance = new Singleton3();
    }

}
