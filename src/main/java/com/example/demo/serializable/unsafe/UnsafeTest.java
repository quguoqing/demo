package com.example.demo.serializable.unsafe;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author: chunmu
 * @Date: 2020/7/24 10:18
 * @Description:
 */
public class UnsafeTest {

    public static void main(String[] args) throws Exception{
        CommonDTO app = new CommonDTO();
        app.setName("程序通事");

        FileOutputStream fos = new FileOutputStream("test.payload");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        //writeObject()方法将Unsafe对象写入object文件
        os.writeObject(app);
        os.close();
        //从文件中反序列化obj对象
        FileInputStream fis = new FileInputStream("test.payload");
        ObjectInputStream ois = new ObjectInputStream(fis);
        //恢复对象
        CommonDTO objectFromDisk = (CommonDTO)ois.readObject();
        System.out.println("main name is "+objectFromDisk.getName());
        ois.close();
    }

}
