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
        int index = findNumberInRotatedArray.findValue(arr, 11, 0, arr.length - 1);
        if(index == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at Index " + index);
    }

    public int findValue(int[] arr, int valueToFind, int start, int finish) {
        if (arr.length < 0)
            return -1;
        if (start == finish && valueToFind == arr[start])
            return start;
        if (finish > start) {
            int mid = (start + finish) / 2;
            if (valueToFind == arr[mid])
                return mid;
            else {
                if(arr[mid] < arr[finish] && valueToFind >= arr[mid] && valueToFind <= arr[finish])
                    return findValue(arr, valueToFind,mid+1, finish);
                else
                    return findValue(arr, valueToFind, start,mid-1);
            }
        }
        return -1;
    }
}
