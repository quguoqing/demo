package com.example.demo.limitrate;

/**
 * @author: chunmu
 * @Date: 2019/11/16 12:16
 * @Description:计数器限流
 * 算法特点：
 * 1.实现简单。
 * 2.时间窗口固定，每个窗口开始时计数为零，这样后面的请求不会受到之前的影响，做到了前后请求隔离。
 * 3.因为两个时间窗口之间没有任何联系，所以调用者可以在一个时间窗口的结束到下一个时间窗口的开始这个非常短的时间段内发起两倍于阈值的请求。所以固定时间窗口算法无法限制窗口间突发流量。
 */
public class CounterLimit {

    public long timeStamp = System.currentTimeMillis();
    public int reqCount = 0;
    // 时间窗口内最大请求数
    public final int limit = 100;
    // 时间窗口ms
    public final long interval = 1000;

    public boolean grant() {
        long now = System.currentTimeMillis();
        //这里有个问题：如果窗口刚结束，大量请求过来了。这里判断均为false，进入下面的else。返回了true。
        // 导致会放掉大量流量，达不到限流的作用。
        if (now < timeStamp + interval) {
            // 在时间窗口内
            reqCount++;
            // 判断当前时间窗口内是否超过最大请求控制数
            return reqCount <= limit;
        } else {
            timeStamp = now;
            // 超时后重置
            reqCount = 1;
            return true;
        }
    }
}
