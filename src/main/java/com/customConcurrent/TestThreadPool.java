package com.customConcurrent;

import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;

/**
 * Created by pjai60 on 11/16/2017.
 */
public class TestThreadPool
{
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        for(int i =0 ; i< 10; i++){
            es.submit(new CustomTask());
        }
        es.shutdown();

    }
}

class CustomTask implements Runnable{

    @Override
    public void run() {
        System.out.println("I am going to sleep  --> " + Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I am done with sleep  --> " + Thread.currentThread().getName());
    }
}
