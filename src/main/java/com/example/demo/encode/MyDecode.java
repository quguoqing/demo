package com.example.demo.encode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * @author: chunmu
 * @Date: 2019/8/19 13:56
 * @Description:
 */
public class MyDecode {

    public static void main(String[] args) {

        try {
            // String path = "/Users/quguoqing/Documents/abc";
            // write(path, "钱", "gbk");
            // System.out.println("write succ");
            // String content = read(path, "utf-8");
            // System.out.println("read=" + content);

            // String result = unicode2Char("\\u94b1\\u4f34\\u5927\\u989d\\u8d37");
            // int a = 38065;
            // char c = (char) a;
            // System.out.println(c);
            String c = "a电";
            System.out.println("utf-8:" + bytes2String(String.valueOf(c).getBytes("utf-8")));
            System.out.println("utf-16:" + bytes2String(String.valueOf(c).getBytes("utf-16")));
            System.out.println("utf-32:" + bytes2String(String.valueOf(c).getBytes("utf-32")));
            System.out.println("gbk:" + bytes2String(String.valueOf(c).getBytes("gbk")));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String bytes2String(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for(byte temp : bytes){
            int b = temp;
            if(b<0){
                b+=256;
            }
            sb.append(Integer.toHexString(b).toUpperCase());
        }
        return sb.toString();
    }

    public static String unicode2Char(String unicodes){
        StringBuffer string = new StringBuffer();
        String[] hex = unicodes.split("\\\\u");
        for(String unicode : hex){
            if(unicode.length() < 4){
                continue;
            }
            String chinese = unicode.substring(0, 4);
            int chr = Integer.parseInt(chinese, 16);
            string.append((char) chr);
        }
        return string.toString();
    }

    public static void write(String path, String content, String encoding)
            throws IOException {
        File file = new File(path);
        file.delete();
        file.createNewFile();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file), encoding));
        writer.write(content);
        writer.close();
    }

    public static String read(String path, String encoding) throws IOException {
        String content = "";
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(file)));
        String line = null;
        while ((line = reader.readLine()) != null) {
            content += line + "\n";
        }
        reader.close();
        return content;
    }
}
