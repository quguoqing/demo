package com.example.demo.reflect;

import java.lang.ref.Reference;
import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * @author: chunmu
 * @Date: 2020/1/9 09:54
 * @Description: 获取对象在内存中的虚拟地址
 */
public class OrderOfObjectsAfterGCMain {

    static final Unsafe unsafe = getUnsafe();
    static final boolean is64bit = true;

    public static void main(String... args) {
        Person person = new Person();

        System.out.println("Before GC");
        print("ascending", person);

        System.gc();
        System.out.println("\nAfter GC");
        print("ascending", person);

        Person[] persons = new Person[1];
        persons[0] = new Person("1");
        // persons[1] = new Person("2");
        System.out.println("length=" + persons.length);
        System.out.println(persons.getClass());
    }

    private static void print(String label, Object a){
        // hashcode
        System.out.println("Hashcode :       " + a.hashCode());
        System.out.println("Hashcode :       " + System.identityHashCode(a));
        // Integer.toHexString(int)是将一个整型转成一个十六进制数
        System.out.println("Hashcode (HEX) : " + Integer.toHexString(a.hashCode()));

        // toString
        System.out.println("toString :       " + String.valueOf(a));
        printAddresses(label, a);
    }

    public static void printAddresses(String label, Object... objects) {
        System.out.print(label + ": 0x");
        long last = 0;
        int offset = unsafe.arrayBaseOffset(objects.getClass());
        int scale = unsafe.arrayIndexScale(objects.getClass());
        switch (scale) {
            case 4:
                long factor = is64bit ? 8 : 1;
                final long i1 = (unsafe.getInt(objects, offset) & 0xFFFFFFFFL) * factor;
                System.out.print(Long.toHexString(i1));
                last = i1;
                for (int i = 1; i < objects.length; i++) {
                    final long i2 = (unsafe.getInt(objects, offset + i * 4) & 0xFFFFFFFFL) * factor;
                    if (i2 > last) {
                        System.out.print(", +" + Long.toHexString(i2 - last));
                    } else {
                        System.out.print(", -" + Long.toHexString(last - i2));
                    }
                    last = i2;
                }
                break;
            case 8:
                throw new AssertionError("Not supported");
            default:
                throw new AssertionError("Not supported");
        }
        System.out.println();
    }

    private static Unsafe getUnsafe() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            return (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

}
