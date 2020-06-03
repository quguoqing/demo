package com.example.demo.bio.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;


/**
 * @author: chunmu
 * @Date: 2020/6/3 22:45
 * @Description:
 */
public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel channel;

    public ReadCompletionHandler(AsynchronousSocketChannel channel){
        if(this.channel == null){
            this.channel = channel;
        }
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        attachment.flip();
        byte[] body = new byte[attachment.remaining()];
        attachment.get(body);
        try {
            String req = new String(body, "UTF-8");
            System.out.println("The time server receive request:" + req);
            String currentTime = ("QUGUOQING".equalsIgnoreCase(req) ? new Date().toString() : "bad query");
            doWrite(currentTime);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            this.channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doWrite(String result){
        if(result != null && result.length() > 0){
            try {
                byte[] bytes = result.getBytes("utf-8");
                ByteBuffer writeBuff = ByteBuffer.allocate(bytes.length);
                writeBuff.put(bytes);
                writeBuff.flip();
                channel.write(writeBuff, writeBuff, new CompletionHandler<Integer, ByteBuffer>() {
                    @Override
                    public void completed(Integer result, ByteBuffer attachment) {
                        if(attachment.hasRemaining()){
                            channel.write(attachment, attachment, this);
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
    }
}
