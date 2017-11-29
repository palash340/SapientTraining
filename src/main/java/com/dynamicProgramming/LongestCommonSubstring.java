package com.dynamicProgramming;

import java.util.Arrays;

/**
 * Created by pjai60 on 11/29/2017.
 */
public class LongestCommonSubstring {
    public static void main(String[] args) {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        int[][] ints = lcs.buildMatrix("zbcdf".toCharArray(),"abcdaf".toCharArray());
        System.out.println(Arrays.deepToString(ints));
        System.out.println(lcs.findMax(ints));

    }

    public int[][] buildMatrix(char[] arr1, char[] arr2){
        int[][] result = new int[arr1.length+1][arr2.length+1];
        // Initialize 0th row and column
        for (int i = 0; i < arr1.length; i++) {
            result[i][0] = 0;
        }
        for (int i = 0; i < arr2.length; i++) {
            result[0][i] = 0;
        }
        for(int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr2.length; j++) {
                if(arr1[i] == arr2[j])
                    result[i+1][j+1] = result[i][j] + 1;
                else
                    result[i+1][j+1] = 0;
            }
        }
        return result;
    }

    public int findMax(int[][] result){
        int max = Integer.MIN_VALUE +1;
        for (int i = 0; i < result.length ; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if(max < result[i][j])
                    max = result[i][j];
            }
        }
        return max;
    }
}
