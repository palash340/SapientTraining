package com.assignment.multiprodcons;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by pjai60 on 10/9/2017.
 */

public class ProducerConsumerDemo {

    public static void main(String args[]){

        BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();
        ExecutorService producerThread = Executors.newFixedThreadPool(10);
        ExecutorService consumerThread = Executors.newFixedThreadPool(10);

        for(int i = 0 ; i < 10; i++){
            producerThread.submit(new Producer(sharedQueue, i+1));
            consumerThread.submit(new Consumer(sharedQueue, i+1));
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        producerThread.shutdown();
        consumerThread.shutdown();

        try {
            producerThread.awaitTermination(5, TimeUnit.SECONDS);
            consumerThread.awaitTermination(5, TimeUnit.SECONDS);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }

}

class Producer implements Runnable {

    private final BlockingQueue<Integer> sharedQueue;
    private int threadNo;

    public Producer(BlockingQueue<Integer> sharedQueue,int threadNo) {
        this.threadNo = threadNo;
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for(int i=1; i<= 5; i++){
            try {
                int number = i+(10*threadNo);
                System.out.println("Produced:" + number + ":by thread:"+ threadNo);
                sharedQueue.put(number);
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
    }

}

class Consumer implements Runnable{

    private final BlockingQueue<Integer> sharedQueue;
    private int threadNo;
    public Consumer (BlockingQueue<Integer> sharedQueue,int threadNo) {
        this.sharedQueue = sharedQueue;
        this.threadNo = threadNo;
    }

    @Override
    public void run() {
        while(true){
            try {
                int num = sharedQueue.take();
                System.out.println("Consumed: "+ num + ":by thread:"+threadNo);
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
    }
}
