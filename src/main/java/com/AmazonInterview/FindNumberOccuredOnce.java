package com.AmazonInterview;

import java.util.HashSet;
import java.util.List;

/**
 * Created by pjai60 on 11/17/2017.
 */
/*
    Write a function that takes an array and size as a parameter. The array contains non-negative numbers.
    Every number in the array appears an even  number of times, except for one number that appears an odd number of times.
    The function should return the number that appears an odd number of times.
*/
public class FindNumberOccuredOnce {
    public static void main(String[] args) {
        FindNumberOccuredOnce findNumberOccuredOnce = new FindNumberOccuredOnce();
        int[] list = new int[]{1,1,7,7,7,2,2,3,3,5,5,6,6};
        System.out.println(findNumberOccuredOnce.usingXOR(list));
        System.out.println(findNumberOccuredOnce.usingHashSet(list));
    }

    public int usingXOR(int[] arr){
        int odd = 0;
        for(int ele : arr){
            odd = (ele ^ odd);
        }
        return odd;
    }

    public HashSet<Integer> usingHashSet(int[] arr){
        HashSet<Integer> finalEle = new HashSet<>();
        for(int val : arr){
            if(finalEle.contains(val))
                finalEle.remove(val);
            else
                finalEle.add(val);
        }
        return finalEle;
    }
}
