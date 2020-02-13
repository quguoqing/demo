package com.example.demo;

/**
 * @author: chunmu
 * @Date: 2020/2/9 15:00
 * @Description:
 */
public class HelloWorld {

    public static void main(String[] args){
        System.out.println("hello world");
        Person person = new Person(18, 110, '张');
        //疑问：
        // 1.person对象怎么知道age1是110，而不是18？
        // 2.18和110，在内存底层存储的是二进制吗？
        System.out.println("name=" + person.getName());
        System.out.println("age1=" + person.getAge1());
        System.out.println("age=" + person.getAge());

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
