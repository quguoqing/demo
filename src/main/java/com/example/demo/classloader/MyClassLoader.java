package com.example.demo.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: chunmu
 * @Date: 2019/11/15 23:02
 * @Description:
 */
public class MyClassLoader extends ClassLoader {

    private String classPath;

    public MyClassLoader(String classPath){
        this.classPath = classPath;
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try{
            byte[] classData = getDate(name);
            if(null == classData){
                throw new ClassNotFoundException();
            }
            return defineClass(name, classData, 0, classData.length);
        }catch (IOException e){
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    //返回类的字节码
    private byte[] getDate(String className) throws IOException {
        InputStream in = null;
        ByteArrayOutputStream out = null;
        String path = classPath
                + File.separatorChar
                + className.replace('.', File.separatorChar)
                + ".class";
        try {
            in = new FileInputStream(path);
            out = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int len = 0;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            return out.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            in.close();
            out.close();
        }
        return null;
    }
}
