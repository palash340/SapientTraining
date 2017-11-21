package com.AmazonInterview;

import java.util.Arrays;

/**
 * Created by pjai60 on 11/21/2017.
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
