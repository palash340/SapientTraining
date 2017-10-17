package com.customDatastructure;


import java.util.concurrent.Callable;

/**
 * Created by Palash on 10/16/2017.
 */
public class CustomHashMap<K, V> {
    final static int DEFAULT_CAPACITY = 16;
    Entry<K, V>[] tab = new Entry[DEFAULT_CAPACITY];

    public void put(K key, V value){
        if(key == null || value == null)
            throw new NullPointerException("Key or Value is null");
        int index = key.hashCode() % DEFAULT_CAPACITY;
        if(tab[index] == null){
            //Do Compare and Set
            tab[index] = new Entry<K, V>(index , key, value, null);
        }
        if(tab[index] != null){
            try {
                tab[index].wait();
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }


    }


    public V get(K key){
        return null;
    }
}
