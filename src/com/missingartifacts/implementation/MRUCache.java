package com.missingartifacts.implementation;

import com.missingartifacts.contract.AbstractCache;

public class MRUCache extends AbstractCache {

    public MRUCache(int cacheSize){
        super(cacheSize);
    }

    public void put(Object key, Object value) {
        if(cacheItemList.size() == this.cacheSize) {
            removeFromTail();
        }
        cacheItemList.addLast(key);
        cacheMap.put(key,value);
    }

    public Object get(Object key) {
        if(cacheItemList.contains(key)) {  // check if it is already in the key list
            if(cacheItemList.remove(key)){   // remove the key to re-add as a first element!
                cacheItemList.addLast(key);
                return cacheMap.get(key);
            }
        }
        return null;
    }
}
