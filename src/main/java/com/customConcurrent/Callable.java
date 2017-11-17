package com.customConcurrent;

/**
 * Created by pjai60 on 11/16/2017.
 */
public interface Callable<V> {
    Future<V> call() throws Exception;
}
