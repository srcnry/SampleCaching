package com.missingartifacts.contract;

public interface ICache {
    public void  put(Object key, Object value);

    public Object get(Object key);

    public void invalidate(Object key);

    public void printCache();
}
