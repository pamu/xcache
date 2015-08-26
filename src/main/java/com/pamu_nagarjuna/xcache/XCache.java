package com.pamu_nagarjuna.xcache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by pnagarjuna on 25/08/15.
 */
public class XCache<K, V> implements Cache<K, V> {

    private final Map<K, V> cache;

    public XCache(int cacheSize) {
        this.cache = new LinkedHashMap<K, V>(cacheSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > cacheSize;
            }
        };
    }
    public XCache(Map<K, V> cache) {
        this.cache = cache;
    }

    @Override
    public void put(K k, V v) {
        synchronized (cache) {
            cache.put(k, v);
        }
    }

    @Override
    public V get(K k) {
        synchronized (cache) {
            return cache.get(k);
        }
    }
}
