package com.recursion;

/**
 * Created by pjai60 on 11/6/2017.
 */
public class FindGCD {
    public static void main(String[] args) {
        FindGCD gcd = new FindGCD();
        System.out.println(gcd.getGCD(111, 3));
        System.out.println(gcd.getGCD(14, 21));
    }

    public int getGCD(int num1, int num2){
        if(num2 != 0)
            return getGCD(num2, num1 % num2);
        else
            return num1;

    }
}
