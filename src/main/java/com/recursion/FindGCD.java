package com.recursion;

/**
 * Created by pjai60 on 11/6/2017.
 */
public class FindGCD {
    public static void main(String[] args) {
        int[] vals = {14,21};
        FindGCD gcd = new FindGCD();
        gcd.gcd(vals);
    }

    public void gcd(int[] vals){
        for(int i = 0 ; i < vals.length ; i++)
            System.out.println("vals[" + i + "] = " + vals[i]);
    }


    public int findMin(int[] vals){
        int min = 0;
        return min;
    }

    public boolean containsOdd(){
        return false;
    }
}
