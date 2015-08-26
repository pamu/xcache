package com.pamu_nagarjuna.xcache;

//import java.util.NoSuchElementException;

/**
 * Created by pnagarjuna on 26/08/15.
 */
public interface Cache<K, V> {
    public void put(K k, V v);
    public V get(K k);
    //public V get(K k) throws NoSuchElementException;
}
