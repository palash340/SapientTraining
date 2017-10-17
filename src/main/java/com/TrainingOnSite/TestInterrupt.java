package com.TrainingOnSite;

/**
 * Created by pjai60 on 10/10/2017.
 */
public class TestInterrupt {
    String str1 = "Java";
    String str2 = "UNIX";

    Thread trd1 = new Thread("My Thread 1"){
        public void run(){
            while(true){
                synchronized(str1){
                    synchronized(str2){
                        System.out.println(str1 + str2);
                    }
                }
            }
        }
    };

    Thread trd2 = new Thread("My Thread 2"){
        public void run(){
            while(true){
                synchronized(str2){
                    synchronized(str1){
                        System.out.println(str2 + str1);
                    }
                }
            }
        }
    };

    public static void main(String[] args) throws InterruptedException {
        TestInterrupt ti = new TestInterrupt();
        ti.trd1.start();
        ti.trd2.start();
        Thread.sleep(10000);
        ti.trd1.interrupt();
    }
}
