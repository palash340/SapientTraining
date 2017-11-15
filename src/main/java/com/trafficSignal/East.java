package com.trafficSignal;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by pjai60 on 11/15/2017.
 */
public class East implements Runnable{
    private CyclicBarrier east;
    private CyclicBarrier west;
    private CyclicBarrier south;
    private CyclicBarrier north;

    public East(CyclicBarrier east, CyclicBarrier west, CyclicBarrier south, CyclicBarrier north) {
        this.east = east;
        this.west = west;
        this.south = south;
        this.north = north;
    }

    @Override
    public void run() {
        boolean flag = false ;
        while(true) {
           if(flag)
              System.out.println("East Green Signal");
           else
              System.out.println("East Red Signal");
              TrafficSignal.sleep(1);
        }
    }
}
