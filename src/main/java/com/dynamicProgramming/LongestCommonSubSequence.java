package com.dynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by pjai60 on 11/29/2017.
 */
public class LongestCommonSubSequence {
    public static void main(String[] args) {
        String str1 = "ABCDGH";
        String str2 = "AEDFHR";
        System.out.println(lcsRec(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length()));
        System.out.println(lcsDp(str1.toCharArray(), str2.toCharArray()));
        str1 = "AGGTAB";
        str2 = "GXTXAYB";
        System.out.println(lcsRec(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length()));
        System.out.println(lcsDp(str1.toCharArray(), str2.toCharArray()));
    }

    public static int lcsRec(char[] str1, char[] str2, int length1, int length2){
        if(length1 == 0 || length2 == 0)
            return 0;
        if(str1[length1 - 1 ] == str2[length2 - 1]){
            return 1 + lcsRec(str1, str2, length1-1, length2-1);
        }else{
            return Math.max(lcsRec(str1, str2, length1, length2-1), lcsRec(str1, str2, length1-1, length2));
        }
    }

    public static int lcsDp(char[] str1, char[] str2){
        int[][] dp = new int[str1.length+1][str2.length+1];
        // initialize 0th column and 0th row
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        // fill the matrix
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(str1[i-1] == str2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[str1.length][str2.length];
    }


}
