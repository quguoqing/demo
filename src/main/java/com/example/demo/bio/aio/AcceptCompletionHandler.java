package com.example.demo.bio.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author: chunmu
 * @Date: 2020/6/3 22:39
 * @Description:
 */
public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AioTimerServer.AsynTimerServerHandler> {


    @Override
    public void completed(AsynchronousSocketChannel result,
            AioTimerServer.AsynTimerServerHandler attachment) {
        attachment.asynchronousServerSocketChannel.accept(attachment, this);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        result.read(buffer, buffer, new ReadCompletionHandler(result));
    }

    @Override
    public void failed(Throwable exc, AioTimerServer.AsynTimerServerHandler attachment) {
        exc.printStackTrace();
        attachment.latch.countDown();
    }
}
