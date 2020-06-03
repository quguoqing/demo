package com.example.demo.bio;

/**
 * @author: chunmu
 * @Date: 2020/6/2 22:58
 * @Description:
 */
public class NioTimeClient {

    public static void main(String[] args){
        String host = "127.0.0.1";
        int port = 8080;

        new Thread(new TimeClientHandler(host, port), "NioTimeClient-001").start();
    }

}
