package com.customDatastructure;

/**
 * Created by pjai60 on 10/16/2017.
 */
public class Entry<K , V> {
    final int hash;
    final K key;
    V value;
    Entry<K, V> next;

    protected Entry(int hash, K key, V value, Entry<K,V> next) {
        this.hash = hash;
        this.key =  key;
        this.value = value;
        this.next = next;
    }

    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }
}
