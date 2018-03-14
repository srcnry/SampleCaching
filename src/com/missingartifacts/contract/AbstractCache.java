package com.missingartifacts.contract;

import java.util.HashMap;
import java.util.LinkedList;

public abstract class AbstractCache implements ICache {
    public int cacheSize;
    public HashMap cacheMap;
    public LinkedList cacheItemList;

    public AbstractCache(int cacheSize) {
        this.cacheSize = cacheSize;
        this.cacheMap = new HashMap(cacheSize);
        this.cacheItemList = new LinkedList();
    }

    public abstract void put(Object key, Object value);

    public abstract Object get(Object key);

    public void invalidate(Object key){
        cacheItemList.remove(key);
        cacheMap.remove(key);
    }

    public void printCache(){
        System.out.println("KeyOrder() " + cacheItemList + " Cache content: " + cacheMap);
    }

    public void removeFromTail(){
        Object key = cacheItemList.removeLast();
        cacheMap.remove(key);
    }
}
