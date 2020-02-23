package com.example.demo.thread;

/**
 * @author: chunmu
 * @Date: 2020/2/17 00:02
 * @Description: 使用wait和notify，实现三个线程交替执行
 */
public class PrintABC {

    public static void main(String[] args) throws Exception{
        Object lockA = new Object();
        Object lockB = new Object();
        Object lockC = new Object();

        Thread aThread = new Thread(new PrintABC.PrintAThread(lockA, lockB));
        Thread bThread = new Thread(new PrintABC.PrintBThread(lockB, lockC));
        Thread cThread = new Thread(new PrintABC.PrintCThread(lockC, lockA));

        aThread.start();
        bThread.start();
        cThread.start();

    }



    public static class PrintAThread implements Runnable{

        private Object lockA;

        private Object lockB;

        public PrintAThread(Object lockA, Object lockB){
            this.lockA = lockA;
            this.lockB = lockB;
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i <= 10; i++) {
                    synchronized (lockA) {
                        synchronized (lockB) {
                            System.out.println("A" + i);
                            lockB.notify();
                        }
                        //B锁，自动释放，触发B线程执行。只需要释放A锁即可
                        lockA.wait();
                    }
                }
                System.out.println("A end");
                //这里A end后，必须得唤醒B，否则B一直wait
                synchronized (lockB){
                    lockB.notify();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class PrintBThread implements Runnable{

        private Object lockB;

        private Object lockC;

        public PrintBThread(Object lockB, Object lockC){
            this.lockB = lockB;
            this.lockC = lockC;
        }

        @Override
        public void run() {
            try{
                for (int i = 1; i <= 10; i++) {
                    synchronized (lockB) {
                        synchronized (lockC) {
                            System.out.println("B" + i);
                            lockC.notify();
                        }
                        //自动释放C锁，触发C线程执行。
                        lockB.wait();
                    }
                }
                System.out.println("B end");
                //这里B end后，必须得唤醒C，否则C一直wait
                synchronized (lockC){
                    lockC.notify();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static class PrintCThread implements Runnable{

        private Object lockC;

        private Object lockA;

        public PrintCThread(Object lockC, Object lockA){
            this.lockC = lockC;
            this.lockA = lockA;
        }

        @Override
        public void run() {
            try{
                for (int i = 1; i <= 10; i++) {
                    synchronized (lockC) {
                        synchronized (lockA) {
                            System.out.println("C" + i);
                            lockA.notify();
                        }
                        //lockA执行为同步代码块，自动释放了A锁，触发A线程执行。这个时候只释放C即可
                        lockC.wait();
                    }
                }
                System.out.println("C end");
                //这里C end后，可以不用再唤醒A了，因为A线程已经结束停止了
                synchronized (lockA){
                    lockA.notify();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
