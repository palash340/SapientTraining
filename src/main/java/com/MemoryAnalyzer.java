package com;

/**
 * Created by pjai60 on 11/15/2017.
 */
public class MemoryAnalyzer {

    public static void main(String[] args) {
        MyCustomThread mct = new MyCustomThread();
        Thread t = new Thread(mct);
        t.setName("MyThread");
        t.start();
    }


    public static void sleep(long timeInMillis){
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class MyCustomThread implements Runnable{
    private String s = new String("a");
    @Override
    public void run() {
        while(true){
            s = s.concat(s);
            s.intern();
            System.out.println(s);
            MemoryAnalyzer.sleep(20000);
        }
    }
}
