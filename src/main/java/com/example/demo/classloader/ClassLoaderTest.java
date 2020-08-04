package com.example.demo.classloader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// import com.example.demo.bean.ServiceA;

import com.alibaba.dubbo.common.json.JSON;
import com.example.demo.bean.ServiceA;
import com.fasterxml.jackson.databind.util.JSONPObject;

import sun.awt.motif.X11GBK;
import sun.tools.jconsole.JConsole;
import sun.util.resources.cldr.aa.CalendarData_aa_ET;

/**
 * @author: chunmu
 * @Date: 2019/11/15 22:31
 * @Description:
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception{
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        ClassLoader result1 = HashMap.class.getClassLoader();
        System.out.println(result1);

        ClassLoader result3 = X11GBK.class.getClassLoader();
        System.out.println(result3);

        ClassLoader result4 = CalendarData_aa_ET.class.getClassLoader();
        System.out.println(result4);

        ClassLoader result2 = ServiceA.class.getClassLoader();
        System.out.println(result2);

        ClassLoader result6 = JConsole.class.getClassLoader();
        System.out.println(result6);

        MyClassLoader myClassLoader = new MyClassLoader("/Users/quguoqing/Documents");
        try{
            //如果删除本工程中的ServiceA类，那么类加载器就是MyClassLoader。否则由于loanClass使用了双亲委派，就会AppClassLoader
            Class clazz = myClassLoader.loadClass("com.example.demo.bean.ServiceA");
            ClassLoader myClass = clazz.getClassLoader();
            System.out.println(myClass);
            clazz.newInstance();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        Map<String, String> map = new LinkedHashMap<>();
        map.put("a", "a");

        map.entrySet().iterator();


        List<String> result = new ArrayList<>();
        result.add("1102");
        result.add("1130");
        System.out.println(JSON.json(result));

        System.out.println("=========");
        myClassLoader = null;

        System.gc();
        Thread.sleep(1000);
        System.out.println("=========");

    }

}
