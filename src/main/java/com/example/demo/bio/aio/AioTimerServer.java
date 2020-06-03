package com.example.demo.bio.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * @author: chunmu
 * @Date: 2020/6/3 22:34
 * @Description:
 */
public class AioTimerServer {

    public static void main(String[] args){
        int port = 8080;

        new Thread(new AsynTimerServerHandler(port), "AIO-AsynTimerServerHandler-001").start();
    }

    public static class AsynTimerServerHandler implements Runnable{

        private int port;

        AsynchronousServerSocketChannel asynchronousServerSocketChannel;

        CountDownLatch latch;

        public AsynTimerServerHandler(int port){
            this.port = port;
            try {
                asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
                asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
                System.out.println("The time server is start in port:" + port);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            latch = new CountDownLatch(1);
            doAccept();
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void doAccept(){
            asynchronousServerSocketChannel.accept(this, new AcceptCompletionHandler());
        }
    }

}
