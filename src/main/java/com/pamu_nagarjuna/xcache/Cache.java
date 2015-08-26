package com.pamu_nagarjuna.xcache;

//import java.util.NoSuchElementException;

/**
 * Created by pnagarjuna on 26/08/15.
 */

/**
 *
 * @param <K>
 * @param <V>
 */
public interface Cache<K, V> {
    /**
     *
     * @param k
     * @param v
     */
    public void put(K k, V v);

    /**
     *
     * @param k
     * @return
     */
    public V get(K k);
    //public V get(K k) throws NoSuchElementException;
}
