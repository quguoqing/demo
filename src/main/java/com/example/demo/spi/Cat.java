package com.example.demo.spi;

/**
 * @author: chunmu
 * @Date: 2019/8/17 16:48
 * @Description:
 */
public class Cat implements IShot {
    //cat object size least 16Byte, mark world size 32bit=4Byte(32bit JVM)

    // private int a = 1;
    //
    // private int b = 1;

    @Override
    public void shout() {
        System.out.println("miao miao");
    }

    public static void main(String[] args) throws Exception{
        Cat cat = new Cat();
        Thread.sleep(1000000L);
    }
}
