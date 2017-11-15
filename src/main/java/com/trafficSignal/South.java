package com.trafficSignal;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by pjai60 on 11/15/2017.
 */
public class South  implements Runnable{
    private CyclicBarrier east;
    private CyclicBarrier west;
    private CyclicBarrier south;
    private CyclicBarrier north;

    public South(CyclicBarrier east, CyclicBarrier west, CyclicBarrier south, CyclicBarrier north) {
        this.east = east;
        this.west = west;
        this.south = south;
        this.north = north;
    }

    @Override
    public void run() {
        boolean flag = true;
        while(true) {
            if(flag)
                System.out.println("South Green Signal");
            else
                System.out.println("South Red Signal");
            TrafficSignal.sleep(1);
        }
    }
}
