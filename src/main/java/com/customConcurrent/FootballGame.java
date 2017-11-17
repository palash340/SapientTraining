package com.customConcurrent;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by pjai60 on 11/16/2017.
 */
public class FootballGame {
    public static void main(String[] args) throws InterruptedException {
        FootballGame footballGame = new FootballGame();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for(int i = 0 ; i < 6 ; i++){
            if(i == 2 || i == 4){
                Thread.sleep(10000);
            }
            new Thread(new Player(cyclicBarrier)).start();
        }


        /*for(int i = 0 ; i < 5 ; i++){
            if(i == 2){
                Thread.sleep(10000);
            }
            new Thread(new Player1(countDownLatch)).start();
        }*/
    }
}


class Player implements Runnable {
    CyclicBarrier cyclicBarrier;

    public Player(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("Started Thread : " + Thread.currentThread().getName());
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("Finished Thread : " + Thread.currentThread().getName());
    }
}


class Player1 implements Runnable{
    CountDownLatch countDownLatch;

    public Player1(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Started Thread : " + Thread.currentThread().getName());
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished Thread : " + Thread.currentThread().getName());
    }
}
