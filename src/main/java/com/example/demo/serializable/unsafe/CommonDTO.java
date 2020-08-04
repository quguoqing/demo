package com.example.demo.serializable.unsafe;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author: chunmu
 * @Date: 2020/7/24 10:16
 * @Description:
 */

public class CommonDTO implements Serializable {
    private static final long serialVersionUID = 6364267506581088787L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;


    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        System.out.println("readObject name is "+name);
        Runtime.getRuntime().exec("open -a Calculator");
    }

}
