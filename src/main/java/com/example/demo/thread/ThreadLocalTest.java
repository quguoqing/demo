package com.example.demo.thread;

import java.text.SimpleDateFormat;

/**
 * @author: chunmu
 * @Date: 2020/2/18 20:38
 * @Description:
 */
public class ThreadLocalTest {

    private static final ThreadLocal<SimpleDateFormat> FORMATTER = ThreadLocal.withInitial(() -> new
            SimpleDateFormat("yyyy/MM/dd"));

    private static final ThreadLocal<SimpleDateFormat> FORMATTER1 = ThreadLocal.withInitial(() -> new
            SimpleDateFormat("yyyyMMdd"));

    public static void main(String[] args){
        SimpleDateFormat sdf1 = FORMATTER.get();
        System.out.println(sdf1.getClass());

        SimpleDateFormat sdf2 = FORMATTER1.get();
        System.out.println(sdf2.getClass());
    }

}
