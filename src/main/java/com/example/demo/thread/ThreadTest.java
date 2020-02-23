package com.example.demo.thread;

/**
 * @author: chunmu
 * @Date: 2020/2/16 22:54
 * @Description:
 */
public class ThreadTest {

    public static void main(String[] args){
        try{
            System.out.println("a");
            Thread thread1 = new Thread(new Thread1());
            thread1.start();
            //只要thread1不结束，join就永远不会被唤醒。
            thread1.join(0);

            System.out.println("b");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static class Thread1 implements Runnable{

        @Override
        public void run() {
            try{
                System.out.println("Thread1 start");
                for(int i=1; i<=5;i++){
                    Thread.sleep(2000);
                    Thread current = Thread.currentThread();
                    synchronized (current){
                        current.notify();
                        System.out.println("Thread1 notify times=" + i);
                    }
                }
                System.out.println("Thread1 end");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
