package com.AmazonInterview;

/**
 * Created by pjai60 on 12/2/2017.
 */

// Given n, print all n digits number in which the digits are in increasing order. a1<a2<a3<a4<a5. 12345 is a valid number but 12354 is not.
public class PrintAllNumIncSeq {
    public static void main(String[] args) {
        PrintAllNumIncSeq printAllNumIncSeq = new PrintAllNumIncSeq();
        printAllNumIncSeq.printAllNumbers(0, "", 2);
    }

    public void printAllNumbers(int index, String str, int n){
        if(n == 0)
            System.out.println(str);
        for (int i = index; i <= 9; i++) {
            String str1 = str + i;
            printAllNumbers(i+1, str1, n-1);
        }
    }
}
