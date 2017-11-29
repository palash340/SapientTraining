package com.AmazonInterview;

import java.util.Arrays;

/**
 * Created by pjai60 on 11/29/2017.
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        int[] slidingWindowMax = swm.findSlidingWindowMax(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 3);
        System.out.println(Arrays.toString(slidingWindowMax));
    }

    public int[] findSlidingWindowMax(int[] source, int windowSize){
        int[] result = new int[source.length - windowSize + 1];
        for (int i = 0; i < source.length - windowSize + 1 ; i++) {
            result[i] = findMax(source, i, i+windowSize-1);
        }
        return result;
    }

    private int findMax(int[] arr, int start, int end){
        int max = -1;
        for (int i = start; i <= end; i++) {
            max = Math.max(arr[i], max);
        }
        return max;
    }
}
