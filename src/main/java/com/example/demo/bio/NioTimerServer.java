package com.example.demo.bio;

/**
 * @author: chunmu
 * @Date: 2020/6/2 22:19
 * @Description:
 */
public class NioTimerServer {

    public static void main(String[] args){
        int port = 8080;
        MultiplexerTimerServer timerServer = new MultiplexerTimerServer(port);
        new Thread(timerServer, "NIO-MultiplexerTimerServer-001").start();
    }
}
