package com.example.demo.encode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: chunmu
 * @Date: 2019/8/23 13:04
 * @Description:
 */
public class MyCacheHashMap extends LinkedHashMap {

    private static final long serialVersionUID = -1067054568170066021L;

    private int MAX_CAPACITY = Integer.MAX_VALUE;

    public MyCacheHashMap(int maxCapacity, boolean accessOrder){
        super(16, 0.75f, accessOrder);
        if(maxCapacity > 0){
            MAX_CAPACITY = maxCapacity;
        }
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_CAPACITY;
    }

}
