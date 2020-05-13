package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * @author: chunmu
 * @Date: 2020/2/9 15:00
 * @Description:
 */
public class HelloWorld {


    public static void main(String[] args){
        Map<String, Integer> map = new HashMap<>();
        Integer b = (null != map ? map.get("test") : Integer.valueOf(1));

        String str = "a \nb";
        System.out.println(str);
    }


    public static void main1(String[] args){
        String abc = "ABC";

        char[] a = new char[3];
        a[0] = '国';
        for(char i : a){
            System.out.println(i);
        }
        System.out.println(Integer.toHexString(new String(a).codePointAt(0)));

        Map table = new Hashtable<>();
        // table.put("a", null);

        System.out.println("hello world");
        Person person = new Person(18, 110, '张');
        //疑问：
        // 1.person对象怎么知道age1是110，而不是18？
        // 2.18和110，在内存底层存储的是二进制吗？
        System.out.println("name=" + person.getName());
        System.out.println("age1=" + person.getAge1());
        System.out.println("age=" + person.getAge());

        char c1 = '严';
        char c2 = 'a';
        String c3 = "严";

        System.out.println("c1=" + c1);
        System.out.println("c2=" + c2);
        System.out.println("c3=" + c3);

        String str = new String("a屈国庆");
        int codePoint1 = str.codePointAt(0);
        System.out.println("codePoint1=" + codePoint1);

        int codePoint2 = str.codePointAt(1);
        System.out.println("codePoint2=" + codePoint2);

        //汉字 '严'
        char yan = '\u4e25';
        char[] codeUnits = Character.toChars(0x4e25);
        System.out.printf("汉字："+yan+" 代码点所占代码单元长度"+codeUnits.length+ " (0x%x) ,它属于基本多语言级别。\n",(int)codeUnits[0]);

        //辅助字符 supplementary character
        //代码点0x1d56b
        codeUnits = Character.toChars(0x1d56b);
        //判断代码单元的高低位
        System.out.printf("代码点0x%x 在UTF-16表示中被分解为两个代码单元 0x%x 0x%x \n", 0x105600,(int)codeUnits[0],(int)codeUnits[1]);
        System.out.printf("0x%x is HighSurrogate:"+Character.isHighSurrogate(codeUnits[0])+ "\n",(int)codeUnits[0]);
        System.out.printf("0x%x is HighSurrogate:"+Character.isHighSurrogate(codeUnits[1])+ "\n",(int)codeUnits[1]);
        System.out.printf("0x%x is LowSurrogate:"+Character.isLowSurrogate(codeUnits[0])+"\n", (int)codeUnits[0]);
        System.out.printf("0x%x is LowSurrogate:"+Character.isLowSurrogate(codeUnits[1])+"\n", (int)codeUnits[1]);

        List<Person> people = new ArrayList<>();
        while (true){
            people.add(new Person(18, 14, 'a'));
            try{
                Thread.sleep(10L);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    static class Person{
        public Person(int age, int age1, char name){
            this.age = age;
            this.age1 = age1;
            this.name = name;
        }
        char name;
        int age;
        int age1;

        public int getAge() {
            return age;
        }

        public int getAge1() {
            return age1;
        }

        public char getName() {
            return name;
        }
    }
}
