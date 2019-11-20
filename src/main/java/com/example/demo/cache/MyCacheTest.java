package com.example.demo.cache;

import java.util.Map;

/**
 * @author: chunmu
 * @Date: 2019/11/17 22:27
 * @Description:
 */
public class MyCacheTest {

    public static void main(String[] args){
        // MyLinkedHashMap<String, String> myLinkedHashMap = new MyLinkedHashMap(3);
        // myLinkedHashMap.put("a", "a");
        // myLinkedHashMap.put("b", "b");
        // myLinkedHashMap.put("c", "c");
        //
        // myLinkedHashMap.put("d", "d");
        // myLinkedHashMap.put("e", "e");
        //
        // for(Map.Entry<String, String> entry : myLinkedHashMap.entrySet()){
        //     System.out.println(entry.getKey() + ":" + entry.getValue());
        // }


        MyQueue myQueue = new MyQueue();
        // myQueue.add(1);
        // myQueue.add(2);
        // myQueue.add(3);
        // myQueue.add(4);
        // myQueue.add(5);
        // myQueue.add(6);

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i < 1000; i++){
                    System.out.println("add=" + i);
                    try {
                        myQueue.add(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try{
                        Thread.sleep(1000L);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                for(int i=1000; i < 2000; i++){
                    System.out.println("add=" + i);
                    try {
                        myQueue.add(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try{
                        Thread.sleep(1000L);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        // t2.start();


        Runnable task3 = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i < 2000; i++){
                    try {
                        System.out.println("poll=" + myQueue.poll());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try{
                        Thread.sleep(1000L);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t3 = new Thread(task3);
        t3.start();

    }
}
