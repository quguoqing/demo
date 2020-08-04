package com.example.demo.lock;

/**
 * @author: chunmu
 * @Date: 2020/6/28 18:03
 * @Description:
 */
public class VolatileTest {

    private int a = 0;

    private volatile int b = 0;

    private int  c = 0;

    int[] array1 = new int[10];

    int[] array2 = new int[10];

    public static void main(String[] args){

        VolatileTest test = new VolatileTest();
        System.out.println(test.b);
        test.a = 3;
        test.b = 2;

        synchronized (test){
            test.c += 1;
        }


        System.out.println("array1.class = " + test.array1.getClass());
        System.out.println("array2.class = " + test.array2.getClass());

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        int   MIN_VALUE = 0x80000000;
        int min1 = 80000000;
        System.out.println(MIN_VALUE);
        System.out.println(min1);

        /**
         * m1 = -1;
         * -1的源码：0x80000001
         * 对源码取反（符号位不变）：0xfffffffe
         * 对反码加1：0xfffffffe + 1 = 0xffffffff
         */
        int m1 = 0xFFFFFFFF;
        System.out.println("m1=" + m1);

        //m2 = 0
        int m2 = 0x00000000;
        System.out.println("m2=" + m2);


        int m3 = 0x80000000;
        System.out.println("m3=" + m3);

        int m3_1 = 0x80000001;
        System.out.println("m3_1=" + m3_1);

        //m4=-8
        int m4 = 0xFFFFFFF8;
        System.out.println("m4=" + m4);

        short m5 = (short) 0x8000;
        System.out.println("m5=" + m5);

        byte m6 = (byte) 0x80;
        System.out.println("m6=" + m6);

    }
}
