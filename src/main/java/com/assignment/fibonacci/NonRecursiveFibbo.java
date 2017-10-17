package com.assignment.fibonacci;

/**
 * Created by pjai60 on 10/9/2017.
 */
public class NonRecursiveFibbo {
    public static void main(String[] args) {
        {
            long initialValue1 =0,initialValue2 = 1;
            long tempVal,count=10;
            System.out.print(initialValue1+" "+initialValue2);//printing 0 and 1

            for(int i=2 ; i<count; ++i)//loop starts from 2 because 0 and 1 are already printed
            {
                tempVal=initialValue1+initialValue2;
                System.out.print(" "+tempVal);
                initialValue1=initialValue2;
                initialValue2=tempVal;
            }
        }}
}
