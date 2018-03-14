package com.missingartifacts;

import com.missingartifacts.contract.ICache;
import com.missingartifacts.enumConstants.CachingStrategy;
import com.missingartifacts.factory.CacheFactory;

public class Main {

    public static void main(String[] args) {

        ICache cacheInstance = CacheFactory.getInstance(3, CachingStrategy.LRU);
        cacheInstance.put("1","test cache 1");
        cacheInstance.put("2","test cache 2");
        cacheInstance.put("3","test cache 3");

        cacheInstance.printCache();

        cacheInstance.put("4","test cache 4");
        cacheInstance.put("5","test cache 5");
        cacheInstance.printCache();
    }
}
