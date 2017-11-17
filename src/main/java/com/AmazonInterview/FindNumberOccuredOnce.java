package com.AmazonInterview;

import java.util.List;

/**
 * Created by pjai60 on 11/17/2017.
 */
public class FindNumberOccuredOnce {
    public static void main(String[] args) {
        int[] list = new int[]{1,1,7,7,7,2,2,3,3,5,5,6,6};
        int odd = 0;
        for(int ele : list){
            odd = (ele ^ odd);
        }
        System.out.println(odd);
    }
}
