package com.pamu_nagarjuna.xcache;

/**
 * Created by pnagarjuna on 25/08/15.
 */

import java.util.Map;

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
        this.cache = new ConcurrentLinkedHashMap.Builder<K, V>().maximumWeightedCapacity(cacheSize).build();
    }

    /**
     *
     * @param k
     * @param v
     */
    @Override
    public void put(K k, V v) {
       cache.put(k, v);
    }

    /**
     *
     * @param k
     * @return
     */
    @Override
    public V get(K k) {
      return cache.get(k);
    }

    public Map<K, V> getCache() {
        return cache;
    }
}
