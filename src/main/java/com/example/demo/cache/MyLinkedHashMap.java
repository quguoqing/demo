package com.example.demo.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: chunmu
 * @Date: 2019/11/17 22:27
 * @Description:
 */
public class MyLinkedHashMap<K,V> extends LinkedHashMap<K,V> {
    private static final long serialVersionUID = 7628625780571197690L;

    private int count;
    public MyLinkedHashMap(int count){
        super(count);
        this.count = count;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        if(size() > count){
            return true;
        }
        return false;
    }
}
