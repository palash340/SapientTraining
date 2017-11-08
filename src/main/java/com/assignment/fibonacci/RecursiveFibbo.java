package com.assignment.fibonacci;

/**
 * Created by pjai60 on 10/9/2017.
 */
public class RecursiveFibbo {
    long tempVal =0;
    private void printFibonacci(long initialValue1, long initialValue2, int count){
        if(count>0){
            tempVal = initialValue1 + initialValue2;
            initialValue1 = initialValue2;
            initialValue2 = tempVal;
            printFibonacci(initialValue1, initialValue2, count-1);
        }else{
            System.out.println();
        }


    }
    public static void main(String args[]) {
        RecursiveFibbo rf = new RecursiveFibbo();
        int count = 10;
        long initialValue1 = 0, initialValue2 = 1;
        System.out.print(initialValue1 + " " + initialValue2);//printing 0 and 1
        rf.printFibonacci(initialValue1, initialValue2, count - 2);//n-2 because 2 numbers are already printed
    }
}
