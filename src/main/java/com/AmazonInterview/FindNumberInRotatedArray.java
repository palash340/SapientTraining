package com.AmazonInterview;

/**
 * Created by pjai60 on 11/21/2017.
 */
/*
    Find a value in a looped sorted list of integers
    For example, 2, 3, 6, 11, 17 21 --> 17, 21, 2, 3, 6, 11
    find if 19 is in the list (efficiently).
*/
public class FindNumberInRotatedArray {
    public static void main(String[] args) {
        FindNumberInRotatedArray findNumberInRotatedArray = new FindNumberInRotatedArray();
        int[] arr =  {17, 21, 2, 3, 6, 11};
        int index = findNumberInRotatedArray.findValue(arr, 19);
        if(index == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at Index " + index);
    }

    public int findValue(int[] arr, int valueToFind){
        if(arr.length <= 0)
            return -1;
        int left = 0, right = arr.length -1;
        boolean isReversed = false;
        while(left != right){
            if(arr[left] == valueToFind)
                return left;
            if(arr[right] == valueToFind)
                return right;
            if(arr[left] > arr[left+1]){

            }
        }
        return -1;
    }

    public int findRotateIndex(int[] arr){
        return findRotateIndex(arr, 0, arr.length);
    }

    private int findRotateIndex(int[] arr, int start, int end){
        if(arr[start] > arr[end]){
            return -1;
        }
        return -1;
    }
}
