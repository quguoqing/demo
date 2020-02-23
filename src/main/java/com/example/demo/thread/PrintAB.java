package com.example.demo.thread;

/**
 * @author: chunmu
 * @Date: 2020/2/16 23:18
 * @Description:
 */
public class PrintAB {

    public static void main(String[] args){
        Object lock = new Object();
        Thread aThread = new Thread(new PrintAThread(lock));
        Thread bThread = new Thread(new PrintBThread(lock));
        aThread.start();
        bThread.start();

    }

    public static class PrintAThread implements Runnable{

        private Object lock;

        public PrintAThread(Object lock){
            this.lock = lock;
        }

        @Override
        public void run() {
            try{
                synchronized (lock){
                    for(int i=1 ; i<= 10; i++){
                        System.out.println("A" + i);
                        lock.notify();
                        lock.wait();
                    }
                    //防止死锁，必须得是第一个打印的线程notify
                    lock.notify();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static class PrintBThread implements Runnable{
        private Object lock;

        public PrintBThread(Object lock){
            this.lock = lock;
        }

        @Override
        public void run() {
            try{
                synchronized (lock){
                    for(int i=1 ; i<= 10; i++){
                        System.out.println("B" + i);
                        lock.notify();
                        // Thread.sleep(1000L);
                        lock.wait();
                    }
                    //防止死锁，可以有，也可以不有。
                    lock.notify();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
