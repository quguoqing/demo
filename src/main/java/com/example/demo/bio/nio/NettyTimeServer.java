package com.example.demo.bio.nio;

/**
 * @author: chunmu
 * @Date: 2020/6/4 17:43
 * @Description:
 */
public class NettyTimeServer {

    public static void main(String[] args){
        int port = 8080;

        new TimeServer().bind(port);
    }

}
