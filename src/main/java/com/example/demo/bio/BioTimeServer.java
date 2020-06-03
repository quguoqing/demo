package com.example.demo.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @author: chunmu
 * @Date: 2020/6/3 17:26
 * @Description:
 */
public class BioTimeServer {

    public static void main(String[] args){
        int port = 8080;

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("The bio server start in port:" + port);
            Socket client = null;
            while (true){
                client = serverSocket.accept();
                new Thread(new BioTimeServerHanlder(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class BioTimeServerHanlder implements Runnable{

        private Socket socket;

        public BioTimeServerHanlder(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("bio server accept thread:" + Thread.currentThread().getName() + " socket:" + socket);
            BufferedReader in = null;
            PrintWriter writer = null;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                writer = new PrintWriter(socket.getOutputStream(), true);
                String body = null;
                while (true){
                    body = in.readLine();
                    if(null == body){
                        break;
                    }
                    System.out.println("The time server receive body:" + body);
                    String result = ("QUGUOQING".equalsIgnoreCase(body) ? new Date().toString() : "bad query");
                    writer.print(result + "\n");
                    writer.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(null != in){
                    try {
                        in.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
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

}
