package com.example.demo.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: chunmu
 * @Date: 2020/5/14 16:30
 * @Description:
 */
public class FileStreamTest {

    public static void main(String[] args) throws InterruptedException {
        String path = "/Users/quguoqing/Documents/quguoqing";
        int num = 1;
        while (true){
            readNoClose(num, path);
            num++;
            // Thread.sleep(1000L);
        }
    }

    private static void readNoClose(int num, String fileName){
        try{
            InputStream in = new FileInputStream(fileName);
            byte[] tempbytes = new byte[1024];
            int byteread = in.read(tempbytes);
            System.out.println("num=" + num + ",size=" + byteread);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
