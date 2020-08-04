package com.example.demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: chunmu
 * @Date: 2019/8/28 16:50
 * @Description:
 */
public class ReflectTest {

    public static void main(String[] args)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, NoSuchFieldException {
        // testContructor("com.example.demo.reflect.ReflectTest$Person");
        // testMethod("com.example.demo.reflect.ReflectTest$Person");
        // testFileds("com.example.demo.reflect.ReflectTest$Person");

        // instance("com.example.demo.reflect.Person");

        for(int i=0; i<10; i++){
            System.out.println("start " + i + "test...");
            testRelectInvokeSpendTime();
        }
    }

    private static void  testRelectInvokeSpendTime()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person person = new Person("qgq", 1);
        int num = 1000000;
        int age1 = 0;
        Long start = System.currentTimeMillis();
        for(int i=0; i<num; i++){
            age1 = person.getAge() + age1;

        }
        System.out.println("common invoke age1=" + age1 + ",spend=" + (System.currentTimeMillis() - start) + "ms");

        Method method = person.getClass().getMethod("getAge",null);
        int age2 = 0;
        Long start1 = System.currentTimeMillis();
        for(int i=0; i<num; i++){
            int age = (int)method.invoke(person);
            age2 = age2 + age;
        }
        System.out.println("reflect invoke age2=" + age2 + ",spend=" + (System.currentTimeMillis() - start1) + "ms");
    }

    public static void testContructor(String className) throws ClassNotFoundException {
        Class<?> clas = Class.forName(className);
        Constructor<?>[] constructors = clas.getConstructors();
        for(Constructor constructor : constructors){
            System.out.println(constructor);
        }
    }

    public static void instance(String className)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<?> clas = Class.forName(className);

        Constructor constructor = clas.getDeclaredConstructor(String.class, Integer.class);
        Object person = constructor.newInstance("屈国庆", 26);
        System.out.println(person);

        Method method = clas.getDeclaredMethod("setName", String.class);
        method.invoke(person, "屈国庆1");
        System.out.println(person);

        Field field = clas.getDeclaredField("name");
        field.setAccessible(true);
        field.set(person, "屈国庆2");
        System.out.println(person);

    }

    public static void testMethod(String className) throws ClassNotFoundException {
        Class<?> clas = Class.forName(className);
        Method[] methods = clas.getMethods();
        for(Method method : methods){
            System.out.println(method);
        }
    }

    public static void testFileds(String className) throws ClassNotFoundException {
        Class<?> clas = Class.forName(className);
        Field[] fields = clas.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field);
        }
    }
}
