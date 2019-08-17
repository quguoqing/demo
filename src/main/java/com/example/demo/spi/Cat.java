package com.example.demo.spi;

/**
 * @author: chunmu
 * @Date: 2019/8/17 16:48
 * @Description:
 */
public class Cat implements IShot {

    @Override
    public void shout() {
        System.out.println("miao miao");
    }
}
