package com.customConcurrent;

/**
 * Created by pjai60 on 11/16/2017.
 */
public class Future<V> {
    Exception e;
    V value;

    public V get() throws Exception {
        if(e != null){
            throw e;
        }
        return value;
    }

    public boolean isDone(){
        return true;
    }

    public Exception getE() {
        return e;
    }

    public void setE(Exception e) {
        this.e = e;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
