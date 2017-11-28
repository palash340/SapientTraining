package com.dynamicProgramming;

/**
 * Created by pjai60 on 11/28/2017.
 */
public class MinimumNumOfJumps {
    public static void main(String[] args) {
        MinimumNumOfJumps mj = new MinimumNumOfJumps();
        mj.findJumps(new int[]{2,3,1,1,2,4,2,0,1});
    }

    public int findJumps(int[] arr){
        if(arr.length <= 0)
            return 0;
        int[] maxJump = new int[arr.length];
        int[] jumpPath = new int[arr.length];
        maxJump[0] = 0;
        jumpPath[0] = 0;
        for(int i = 1; i < arr.length; i++)
            for(int j = 0; j < i; j++){
                //maxJump[i] = Math.min();
            }
        return maxJump[arr.length - 1];
    }
}
