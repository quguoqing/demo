package com.example.demo.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: chunmu
 * @Date: 2020/5/5 13:41
 * @Description:
 */
public class ConditionTest {

    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException{
        lock.lock();
        try {
            while (count == items.length){
                System.out.println("队列已满，无法装下。线程阻塞，等待非满的信号");
                notFull.await();
            }
            items[putptr] = x;
            if(++putptr == items.length){
                putptr = 0;
            }
            ++count;
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException{
        lock.lock();
        try {
            while (count == 0){
                System.out.println("队列已空，无法获取。线程阻塞，等待非空的信号");
                notEmpty.await();
            }
            Object x = items[takeptr];
            if(++takeptr == items.length){
                takeptr = 0;
            }
            --count;
            notFull.signal();
            return x;
        }finally {
            lock.unlock();
        }
    }

    public  static void main(String[] args) throws Exception{
        ConditionTest test = new ConditionTest();
        test.put("abc");
    }

}
