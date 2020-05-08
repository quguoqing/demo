package com.example.demo.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: chunmu
 * @Date: 2020/5/8 14:18
 * @Description:
 */
public class FutureTest {


    public static void main(String[] args){
        FutureTest test = new FutureTest();
        for(int i=0; i<10; i++){
            CompletableFuture<Integer> feature = new CompletableFuture<>();
            test.handle(feature);
            try {
                Integer result = feature.get();
                System.out.println("result=" + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }


    private void handle(CompletableFuture<Integer> feature){
        Thread handle = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                    feature.complete(1);
                    System.out.println(Thread.currentThread().toString() + "处理完成");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        handle.start();
    }

}
