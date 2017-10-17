package com.assignment.consumerproducer.customQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * Created by pjai60 on 10/11/2017.
 */
public class ProdConsumerQueue {
    public static void main(String[] args) {
        BlockingQueueCustom<Integer> sharedQueue = new CustomBlockingQueue<Integer>(5);
        Thread producer = new Thread(new Producer(sharedQueue, 1));
        Thread consumer = new Thread(new Consumer(sharedQueue, 1));
        producer.start();
        consumer.start();
    }
}

class Consumer implements Runnable{

    private final BlockingQueueCustom<Integer> sharedQueue;
    private int threadNo;
    public Consumer (BlockingQueueCustom<Integer> sharedQueue,int threadNo) {
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


class Producer implements Runnable {

    private final BlockingQueueCustom<Integer> sharedQueue;
    private int threadNo;

    public Producer(BlockingQueueCustom<Integer> sharedQueue,int threadNo) {
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

interface BlockingQueueCustom<E>{
    void put(E item)  throws InterruptedException ;
    E take()  throws InterruptedException;
}

class CustomBlockingQueue<E> implements  BlockingQueueCustom<E>{
    private List<E> queue;
    private int  maxSize ;

    public CustomBlockingQueue(int maxSize){
        this.maxSize = maxSize;
        queue = new LinkedList<E>();
    }

    @Override
    public synchronized void put(E item) throws InterruptedException {
        if (queue.size() == maxSize) {
            this.wait();
        }
        queue.add(item);
        this.notifyAll();
    }

    @Override
    public synchronized  E take() throws InterruptedException {
        if (queue.size() == 0) {
            this.wait();
        }
        this.notifyAll();
        return queue.remove(0);
    }
}
