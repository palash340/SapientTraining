package com.dynamicProgramming;

import java.util.Arrays;

/**
 * Created by pjai60 on 11/28/2017.
 */
public class MinimumNumOfJumps {
    public static void main(String[] args) {
        MinimumNumOfJumps mj = new MinimumNumOfJumps();
        System.out.println(mj.findJumps(new int[]{2,3,1,1,2,4,2,0,1}));
        System.out.println(mj.findJumps(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}));
    }

    public int findJumps(int[] arr){
        if(arr.length <= 0)
            return 0;
        int[] maxJump = new int[arr.length];
        int[] jumpPath = new int[arr.length];
        maxJump[0] = 0;
        jumpPath[0] = -1;

        for(int i=1; i < arr.length ; i++){
            maxJump[i] = Integer.MAX_VALUE-1;
        }

        for(int i = 1; i < arr.length; i++)
            for(int j = 0; j < i; j++){
                if(arr[j] + j >= i) {
                    if (maxJump[i] > maxJump[j] + 1) {
                        maxJump[i] = maxJump[j] + 1;
                        jumpPath[i] = j;
                    }else{
                        //jumpPath[i] = j;
                    }
                }
                else
                    continue;
            }
        //System.out.println(Arrays.toString(maxJump));
        //System.out.println(Arrays.toString(jumpPath));
        return maxJump[arr.length - 1];
    }
}
