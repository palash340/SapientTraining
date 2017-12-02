package com.AmazonInterview;

import java.util.Arrays;

/**
 * Created by pjai60 on 12/2/2017.
 */
public class EditString {
    public static void main(String[] args) {
        String first = "gesek";
        String second = "geek";
        EditString editString = new EditString();
        System.out.println(editString.findEdit(first, second, first.length() - 1, second.length() -1));
        first = "cat";
        second = "cut";
        System.out.println(editString.findEdit(first, second, first.length() - 1, second.length() -1));
        first = "sunday";
        second = "saturday";
        System.out.println(editString.findEdit(first, second, first.length() - 1, second.length() -1));
        System.out.println(editString.findEditDynamic(first, second));

        first = "abcdef";
        second = "azced";
        // Dynamic programming
        System.out.println(editString.findEditDynamic(first, second));
        // Without dynamic
        System.out.println(editString.findEdit(first, second, first.length() - 1, second.length() -1));
    }

    public int findEdit(String first, String second, int index1, int index2){
        if(index1 <= 0)
            return index2;
        if(index2 <= 0)
            return index1;

        if(first.charAt(index1) == second.charAt(index2)) {
            index1--;
            index2--;
            return  findEdit(first, second, index1, index2);
        }

        return 1 + Math.min (Math.min(
                // Addition
                findEdit(first, second, index1, index2-1),
                // Deletion
                findEdit(first, second, index1 -1, index2)
                ),
                // Updating
                findEdit(first, second, index1 -1 , index2 -1));
    }

    public int findEditDynamic(String first, String second){
        int[][] dp = new int[first.length()+1][second.length()+1];
        // Initialize 0th row and column
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        // fill in the values
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if(first.charAt(i-1) == second.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(Math.min( dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]);
                }
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
