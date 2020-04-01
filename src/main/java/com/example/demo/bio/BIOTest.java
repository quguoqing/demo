package com.example.demo.bio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author: chunmu
 * @Date: 2020/3/9 14:55
 * @Description:
 */
public class BIOTest {

    public static void main(String[] args) throws Exception{
        String bio = "/Users/quguoqing/Documents/bio";
        testFileInputStream(bio);
        testFileInputStreamByLine(bio);
        testBufferedInputStream(bio);
        testInputStreamReader(bio);
    }

    private static void testFileInputStream(String path) throws Exception{
        InputStream in = null;
        try{
            in = new FileInputStream(path);
            byte[] buffer = new byte[20];
            in.read(buffer);
            char inchar;
            System.out.println("========testFileInputStream=======");

            for(byte b : buffer){
                if(b == 0){
                    inchar = '-';
                }else {
                    inchar = (char) b;
                }
                System.out.println("int=" + b + ";char=" + inchar);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(in != null){
                in.close();
            }
        }
    }

    private static void testFileInputStreamByLine(String path) throws Exception{
        InputStream in = null;
        try{
            in = new FileInputStream(path);
            byte[] buffer = new byte[100];
            System.out.println("========testFileInputStreamByLine=======");
            int len = 0;
            while ((len = in.read(buffer)) != -1){
                String str = new String(buffer, 0, len, "UTF-8");
                System.out.println(str);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(in != null){
                in.close();
            }
        }
    }

    private static void testBufferedInputStream(String path) throws Exception{
        InputStream in = null;
        in = new BufferedInputStream(new FileInputStream(path));
        byte[] buffer = new byte[100];
        int len = 0;
        System.out.println("========testBufferedInputStream=======");
        while((len = in.read(buffer)) != -1){
            System.out.println(new String(buffer, 0, len, "utf-8"));
        }
    }

    private static void testInputStreamReader(String path) throws Exception{

        Reader in = new InputStreamReader(new FileInputStream(path), "UTF-8");
        char[] buffer = new char[100];
        int len = 0;
        System.out.println("========testInputStreamReader=======");
        while((len = in.read(buffer)) != -1){
            System.out.println(new String(buffer, 0, len));
        }
    }

}
