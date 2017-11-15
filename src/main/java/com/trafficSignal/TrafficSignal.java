package com.trafficSignal;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by pjai60 on 11/15/2017.
 */
public class TrafficSignal {
    public static void main(String[] args) {
        CyclicBarrier east = new CyclicBarrier(2);
        CyclicBarrier west = new CyclicBarrier(2);
        CyclicBarrier south = new CyclicBarrier(2);
        CyclicBarrier north = new CyclicBarrier(2);
        ExecutorService es = Executors.newFixedThreadPool(4);
            es.submit(new East(east, west, south, north));
            es.submit(new West(east, west, south, north));
            es.submit(new South(east, west, south, north));
            es.submit(new North(east, west, south, north));

        sleep(50);
        es.shutdownNow();
    }

    public static void sleep(long timeInSeconds){
        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
