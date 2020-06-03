package com.example.demo.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author: chunmu
 * @Date: 2020/5/22 10:59
 * @Description:
 */
public enum EnumSingleton {

    INSTANCE;

    public static void main(String[] args){
        EnumSingleton instance = EnumSingleton.INSTANCE;
        System.out.println(instance);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
            oos.writeObject(instance);

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("tempFile")));
            EnumSingleton singleton2 = (EnumSingleton)ois.readObject();
            System.out.println(singleton2);
            System.out.println(instance == singleton2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

}
