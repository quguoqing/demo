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
            String path = "/Users/quguoqing/Documents/abc";
            write(path, "中国", "gbk");
            System.out.println("write succ");
            String content = read(path, "utf-8");
            System.out.println("read=" + content);
        } catch (Exception e) {
            System.out.println(e);
        }
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
