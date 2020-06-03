package com.example.demo.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author: chunmu
 * @Date: 2020/6/3 17:45
 * @Description:
 */
public class BioTimeClient {

    public static void main(String[] args){
        String host = "127.0.0.1";
        int port = 8080;
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter writer = null;

        try {
            socket = new Socket(host, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
            writer = new PrintWriter(socket.getOutputStream(), true);
            writer.print("QUGUOQING1" + "\n");
            writer.flush();
            String reply = in.readLine();
            System.out.println("the time client reply:" + reply);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != in){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != writer){
                writer.close();
            }
            if(null != socket){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
