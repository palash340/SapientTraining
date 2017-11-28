package com.dynamicProgramming;

/**
 * Created by pjai60 on 11/28/2017.
 */
public class KadaneAlgorithn {
    public static void main(String[] args) {
        KadaneAlgorithn ka = new KadaneAlgorithn();
        System.out.println(ka.findMax(new int[]{-1,3,-2,5,-6,1}));
    }

    public int findMax(int[] arr){
        if(arr.length <= 0){
            return 0;
        }
        int max_current = arr[0], max_global = arr[0];
        for(int i = 0 ; i < arr.length; i++){
            max_current = Math.max(arr[i], max_current + arr[i]);
            if (max_current > max_global)
                max_global = max_current;
        }
        return max_global;
    }
}
