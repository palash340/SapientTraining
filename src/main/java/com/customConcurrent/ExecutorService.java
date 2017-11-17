package com.customConcurrent;

/**
 * Created by pjai60 on 11/16/2017.
 */
public class ExecutorService
{
    public Future submit(Callable callable) throws NullPointerException{
        if(callable == null)
            throw new NullPointerException();
        Future future = new Future();
        try{
            future.setValue(callable.call());
        }catch (Exception e){
            future.setE(e);
        }
        return future;
    }
}
