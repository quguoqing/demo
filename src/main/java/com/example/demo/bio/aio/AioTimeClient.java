package com.example.demo.bio.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;


/**
 * @author: chunmu
 * @Date: 2020/6/3 22:57
 * @Description:
 */
public class AioTimeClient {

    public static void main(String[] args){
        int port = 8080;
        String host= "127.0.0.1";

        new Thread(new AsyncTimeClientHandler(host, port)).start();
    }

    public static class AsyncTimeClientHandler implements CompletionHandler<Void, AsyncTimeClientHandler>, Runnable{

        private AsynchronousSocketChannel channel;

        private String host;

        private int port;

        private CountDownLatch latch;

        public AsyncTimeClientHandler(String host, int port){
            this.host = host;
            this.port = port;

            try {
                channel = AsynchronousSocketChannel.open();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            latch = new CountDownLatch(1);
            channel.connect(new InetSocketAddress(host, port), this, this);
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void completed(Void result, AsyncTimeClientHandler attachment) {
            try {
                byte[] req = "QUGUOQING".getBytes("utf-8");
                ByteBuffer write = ByteBuffer.allocate(req.length);
                write.put(req);
                write.flip();
                channel.write(write, write, new CompletionHandler<Integer, ByteBuffer>() {
                    @Override
                    public void completed(Integer result, ByteBuffer attachment) {
                        if(attachment.hasRemaining()){
                            channel.write(attachment, attachment, this);
                        }else {
                            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                            channel.read(readBuffer, readBuffer,
                                    new CompletionHandler<Integer, ByteBuffer>() {
                                        @Override
                                        public void completed(Integer result,
                                                ByteBuffer attachment) {
                                            readBuffer.flip();
                                            byte[] bytes = new byte[attachment.remaining()];
                                            attachment.get(bytes);
                                            try {
                                                String body = new String(bytes, "UTF-8");
                                                System.out.println("Now is:" + body);
                                                latch.countDown();
                                            } catch (UnsupportedEncodingException e) {
                                                e.printStackTrace();
                                            }
                                        }

                                        @Override
                                        public void failed(Throwable exc, ByteBuffer attachment) {
                                            try {
                                                channel.close();
                                                latch.countDown();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    });
                        }
                    }

                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {
                        try {
                            channel.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void failed(Throwable exc, AsyncTimeClientHandler attachment) {
            exc.printStackTrace();
            try {
                channel.close();
                latch.countDown();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
