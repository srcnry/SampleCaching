package com.missingartifacts.factory;

import com.missingartifacts.contract.ICache;
import com.missingartifacts.enumConstants.CachingStrategy;
import com.missingartifacts.implementation.LRUCache;
import com.missingartifacts.implementation.MRUCache;

public class CacheFactory {

    private static ICache  cacheInstance = null;

    public static ICache getInstance(int cacheSize, CachingStrategy cachingStrategy){
        if(cacheInstance == null) {
            synchronized (ICache.class){
                if(cacheInstance == null) {
                    if(CachingStrategy.LRU.equals(cachingStrategy)){
                        cacheInstance = new LRUCache(cacheSize);
                    } else if(CachingStrategy.MRU.equals(cachingStrategy)) {
                        cacheInstance = new MRUCache(cacheSize);
                    } else {
                        throw new RuntimeException("Invalid Caching Strategy");
                    }
                }
            }
        }
        return cacheInstance;
    }

}
