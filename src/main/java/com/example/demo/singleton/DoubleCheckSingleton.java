package com.example.demo.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * @author: chunmu
 * @Date: 2020/5/22 10:02
 * @Description: 双重检测，懒汉加载
 */
public class DoubleCheckSingleton implements Serializable {
    private static final long serialVersionUID = -6047252166199627394L;

    private static volatile DoubleCheckSingleton instance = null;

    private DoubleCheckSingleton(){
        if(null != instance){
            throw new RuntimeException("单例已经存在");
        }
    }

    //通过反射破坏单例
    // public static void main(String[] args){
    //     DoubleCheckSingleton singleton1 = getSingleton();
    //     System.out.println(singleton1);
    //     try{
    //         Class<DoubleCheckSingleton> singletonClass = (Class<DoubleCheckSingleton>)Class.forName("com.example.demo.singleton.DoubleCheckSingleton");
    //         Constructor<DoubleCheckSingleton> constructor = singletonClass.getDeclaredConstructor(null);
    //         constructor.setAccessible(true);
    //         DoubleCheckSingleton singleton2 = constructor.newInstance();
    //         System.out.println(singleton2);
    //         System.out.println(singleton1 == singleton2);
    //     }catch (Exception e){
    //        e.printStackTrace();
    //     }
    // }

    //通过反序列化破坏单例
    public static void main(String[] args){
        DoubleCheckSingleton singleton1 = getSingleton();
        System.out.println(singleton1);
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
            oos.writeObject(singleton1);

            File file = new File("tempFile");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            DoubleCheckSingleton singleton2 = (DoubleCheckSingleton)ois.readObject();
            System.out.println(singleton2);
            System.out.println(singleton1 == singleton2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DoubleCheckSingleton getSingleton(){
        if(null == instance){
            synchronized (DoubleCheckSingleton.class){
                if(null == instance){
                    instance = new DoubleCheckSingleton();
                    return instance;
                }
            }
        }
        return instance;
    }

}
