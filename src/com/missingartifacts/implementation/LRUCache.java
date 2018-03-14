package com.missingartifacts.implementation;

import com.missingartifacts.contract.AbstractCache;

public class LRUCache extends AbstractCache {

    public LRUCache(int cacheSize){
        super(cacheSize);
    }

    public void put(Object key, Object value) {
        if(cacheItemList.size() == this.cacheSize){
            removeFromTail();
        }
        cacheItemList.addFirst(key);
        cacheMap.put(key,value);
    }

    public Object get(Object key) {
        if(cacheItemList.contains(key)) {  // check if it is already in the key list
            if(cacheItemList.remove(key)){   // remove the key to re-add as a first element!
                cacheItemList.addFirst(key);
                return cacheMap.get(key);
            }
        }
        return null;
    }
}
