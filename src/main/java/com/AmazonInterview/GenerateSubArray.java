package com.AmazonInterview;

import java.util.Arrays;

/**
 * Created by pjai60 on 11/21/2017.
 */
/*
        You are given an array. Return a same sized array.
        Every value returned is a product of rest of elements other than the ith element (no division allowed)
        [1, 3, 4 , 2] -> [24, 8, 6, 12]
*/
public class GenerateSubArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] destArr = new int[arr.length];
        int[] tempArr = new int[arr.length];
        for(int i = 0 ; i < arr.length ; i++){
            destArr[i] = (i == 0 ) ? 1 : arr[i - 1] * destArr[i-1];
        }
        for(int i = arr.length - 1 ; i >= 0 ; i--){
            tempArr[i] = (i == arr.length - 1 ) ? 1 : arr[i+1]  * tempArr[i+1];
        }
        for(int i = 0; i < arr.length ; i++){
            destArr[i] = tempArr[i] * destArr[i];
            System.out.println(destArr[i]);
        }
    }
}
