package com.example.demo.classloader;

import java.util.HashMap;
import java.util.Map;

// import com.example.demo.bean.ServiceA;

import sun.awt.motif.X11GBK;
import sun.util.resources.cldr.aa.CalendarData_aa_ET;

/**
 * @author: chunmu
 * @Date: 2019/11/15 22:31
 * @Description:
 */
public class ClassLoaderTest {

    public static void main(String[] args){
        // System.out.println(System.getProperty("sun.boot.class.path"));
        // System.out.println(System.getProperty("java.ext.dirs"));
        // ClassLoader result1 = HashMap.class.getClassLoader();
        // System.out.println(result1);
        //
        // ClassLoader result3 = X11GBK.class.getClassLoader();
        // System.out.println(result3);
        //
        // ClassLoader result4 = CalendarData_aa_ET.class.getClassLoader();
        // System.out.println(result4);

        // ClassLoader result2 = ServiceA.class.getClassLoader();
        // System.out.println(result2);

        MyClassLoader myClassLoader = new MyClassLoader("/Users/quguoqing/Documents");
        try{
            //如果删除本工程中的ServiceA类，那么类加载器就是MyClassLoader。否则由于loanClass使用了双亲委派，就会AppClassLoader
            ClassLoader myClass = myClassLoader.loadClass("com.example.demo.bean.ServiceA").getClassLoader();
            System.out.println(myClass);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}
