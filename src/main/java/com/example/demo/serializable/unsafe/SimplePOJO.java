package com.example.demo.serializable.unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import sun.misc.Unsafe;

/**
 * @author: chunmu
 * @Date: 2020/7/26 10:09
 * @Description:
 */
public class SimplePOJO {

    public byte d1 = 1;

    public byte d2 = 1;

    public short c1 = 1;

    public short c2 = 1;

    public int b1 = 1;

    public int b2 = 1;

    public long a2 = 1;

    public long a1 = 2;



    public static void main(String[] args) throws Throwable{
        SimplePOJO simplePOJO = new SimplePOJO();
        Field[] fields = SimplePOJO.class.getFields();
        List<SimpleSort> result =  new ArrayList<>();
        for(Field field : fields){
            result.add(buildSimpleSort(field));
        }
        result.sort(new Comparator<SimpleSort>() {
            @Override
            public int compare(SimpleSort o1, SimpleSort o2) {
                long sort1 = o1.getOffset();
                long sort2 = o2.getOffset();
                if(sort1 > sort2){
                    return 1;
                }else if(sort1 < sort2){
                    return -1;
                }else {
                    return 0;
                }
            }
        });

        for(SimpleSort sort : result){
            System.out.println(sort.getField() + ":" + sort.getOffset());
        }

        System.out.println(simplePOJO.a1);
    }

    private static SimpleSort buildSimpleSort(Field field) throws Throwable{
        Unsafe unsafe = getUnsafe();
        long valueOffset = unsafe.objectFieldOffset(field);

        SimpleSort sort = new SimpleSort();
        sort.setField(field.getName());
        sort.setOffset(valueOffset);
        return sort;
    }


    private static Unsafe getUnsafe() throws Throwable {
        Class<?> unsafeClass = Unsafe.class;
        for (Field f : unsafeClass.getDeclaredFields()) {
            if ("theUnsafe".equals(f.getName())) {
                f.setAccessible(true);
                return (Unsafe) f.get(null);
            }
        }
        throw new IllegalAccessException("no declared field: theUnsafe");
    }

    static class SimpleSort{
        String field;

        long offset;

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public long getOffset() {
            return offset;
        }

        public void setOffset(long offset) {
            this.offset = offset;
        }
    }

}
