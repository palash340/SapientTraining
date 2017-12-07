package com.dynamicProgramming;

public class LongestPanlindromicSubSequence {
    public static void main(String[] args) {
        String str = "agbdba";
        System.out.println(lpsRec(str.toCharArray(), 0, str.length() -1));
    }

    public static int lpsRec(char[] arr, int m, int n){
        //Base Case if there is only one character
        if(m == n)
            return 1;
        if(arr[m] == arr[n] && m+1 == n)
            return 2;

        if(arr[m] == arr[n])
            return 2 + lpsRec(arr, m+1, n-1);

        return Math.max(lpsRec(arr, m+1, n), lpsRec(arr, m, n-1));
    }

    public int lpsDp(char[] arr, int length){
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        int len = 1;
        while(len < length)
        for (int i = 1; i < length-len; i++) {
            int j = i+len;
            // If same then add 2 else max
            if(arr[i] == arr[i+len]){
                dp[i][j] = 2 + 0;
            }else{
                dp[i][0] = Math.max(dp[i-1][i+len], dp[i][i+len-1]);
            }
        }
        return 0;
    }

}
