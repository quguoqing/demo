package com.example.demo.reflect;

/**
 * @author: chunmu
 * @Date: 2019/8/28 17:15
 * @Description:
 */
public class Person {
    private String name;

    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return "name=" + name + ";age=" + age;
    }
}
