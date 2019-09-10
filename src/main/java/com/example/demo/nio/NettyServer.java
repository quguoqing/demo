package com.example.demo.nio;

import java.nio.channels.Selector;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author: chunmu
 * @Date: 2019/8/26 19:25
 * @Description:
 */
public class NettyServer {

    // public static void main1(String[] args){
    //     ServerBootstrap serverBootstrap = new ServerBootstrap();
    //
    //     NioEventLoopGroup boss = new NioEventLoopGroup();
    //     NioEventLoopGroup worker = new NioEventLoopGroup();
    //     serverBootstrap.group(boss, worker)
    //             .channel(NioServerSocketChannel.class)
    //             .childHandler(new ChannelInitializer<NioSocketChannel>() {
    //                 @Override
    //                 protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
    //                     nioSocketChannel.pipeline().addLast(new StringDecoder());
    //                     nioSocketChannel.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
    //                         @Override
    //                         protected void channelRead0(ChannelHandlerContext channelHandlerContext,
    //                                 String s) throws Exception {
    //                             System.out.println(s);
    //                         }
    //                     });
    //                 }
    //             }).bind(8000);
    // }

    private static final int MAXSIZE = 65535;

    public static void main(String args[]) {

        Selector[] sels = new Selector[MAXSIZE];
        try {

            for (int i = 0; i < MAXSIZE; ++i) {

                sels[i] = Selector.open();

                //sels[i].close();

            }

            Thread.sleep(30000);
        } catch (Exception ex) {
        }
    }
}
