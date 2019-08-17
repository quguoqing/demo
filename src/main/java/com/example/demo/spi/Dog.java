package com.example.demo.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author: chunmu
 * @Date: 2019/8/17 16:48
 * @Description:
 */
public class Dog implements IShot {

    @Override
    public void shout() {
        System.out.println("wang wang");
    }

    public static void main(String[] args){
        ServiceLoader<IShot> shotServiceLoader = ServiceLoader.load(IShot.class);
        Iterator iterator = shotServiceLoader.iterator();
        while(iterator.hasNext()){
            IShot shot = (IShot) iterator.next();
            shot.shout();
        }
    }
}
