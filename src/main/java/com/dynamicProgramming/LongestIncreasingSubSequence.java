package com.dynamicProgramming;

import java.util.Arrays;

/**
 * Created by pjai60 on 11/29/2017.
 */
public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence();
        int[] ints = lis.maxSubSequence(new int[]{3, 4, -1, 0, 6, 2, 3});
        System.out.println(Arrays.toString(ints));
    }

    // Time complexity for this is n2
    public int[] maxSubSequence(int[] arr){
        int[] result = new int[arr.length];
        //Initialize the array
        for (int i = 0; i < result.length; i++) {
            result[i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]){
                    result[i] = Math.max(result[j] + 1, result[i]);
                }
            }
        }
        return result;
    }

    // Time complexity in linear time

}
