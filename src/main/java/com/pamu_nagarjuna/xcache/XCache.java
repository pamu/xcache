package com.pamu_nagarjuna.xcache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by pnagarjuna on 25/08/15.
 */

/**
 *
 * @param <K>
 * @param <V>
 */
public class XCache<K, V> implements Cache<K, V> {


    private final Map<K, V> cache;

    /**
     * Parametrised constructor
     * @param cacheSize
     */
    public XCache(final int cacheSize) {
        this.cache = new LinkedHashMap<K, V>(cacheSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > cacheSize;
            }
        };
    }

    /**
     * Default constructor
     */
    public XCache() {
        this.cache = new LinkedHashMap<K, V>(1000, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 1000;
            }
        };
    }

    /**
     *
     * @param cache
     */
    public XCache(Map<K, V> cache) {
        this.cache = cache;
    }

    /**
     *
     * @param k
     * @param v
     */
    @Override
    public void put(K k, V v) {
        synchronized (cache) {
            cache.put(k, v);
        }
    }

    /**
     *
     * @param k
     * @return
     */
    @Override
    public V get(K k) {
        synchronized (cache) {
            return cache.get(k);
        }
    }

    public Map<K, V> getCache() {
        return cache;
    }
}
