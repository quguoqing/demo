package com.example.demo.bio.nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author: chunmu
 * @Date: 2020/6/4 18:13
 * @Description:
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

    private ByteBuf firstMessage;

    private byte[] req;

    private int counter;

    public TimeClientHandler(){
        req = ("QUGUOQING" + System.getProperty("line.separator")).getBytes();
        // firstMessage = Unpooled.buffer(req.length);
        // firstMessage.writeBytes(req);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx){
        ByteBuf message = null;
        for(int i=0; i<100;i++){
            message = Unpooled.buffer(req.length);
            message.writeBytes(req);
            ctx.writeAndFlush(message);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
        // ByteBuf buf = (ByteBuf) msg;
        // byte[] req = new byte[buf.readableBytes()];
        // buf.readBytes(req);
        // String body = new String(req, "UTF-8");

        String body = (String) msg;


        System.out.println("Now is:" + body + "; the counter is:" + (++counter));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        ctx.close();
    }

}
