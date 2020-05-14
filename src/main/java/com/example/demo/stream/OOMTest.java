package com.example.demo.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: chunmu
 * @Date: 2020/5/14 17:16
 * @Description:
 */
public class OOMTest {

    public static void main(String[] args) throws InterruptedException {
        int i=0;
        while (true){
            if(i > 0){
                System.out.println("main thread");
                Thread.sleep(1000L);
                continue;
            }
            Thread t1 = new Thread(() -> {
                List<OOMObject>  refs = new ArrayList<>();
                while (true){
                    OOMObject o1 = new OOMObject();
                    refs.add(o1);
                    System.out.println("thread-1申请1M");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            Thread t2 = new Thread(() -> {
                List<OOMObject>  refs = new ArrayList<>();
                while (true){
                    OOMObject o1 = new OOMObject();
                    refs.add(o1);
                    System.out.println("thread-2申请1M");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            t1.start();
            t2.start();
            i++;
        }
    }

    static class OOMObject {
        byte[] tempbytes = new byte[1024*1024];
    }

}
