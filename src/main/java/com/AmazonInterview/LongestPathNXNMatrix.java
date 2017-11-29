package com.AmazonInterview;

/**
 * Created by pjai60 on 11/29/2017.
 */
public class LongestPathNXNMatrix {
    public final static int N = 3;
    public static void main(String[] args) {
        int  mat[][] = { {1, 2, 9},
                         {4, 3, 8},
                         {5, 6, 7}
                        };
        LongestPathNXNMatrix lp = new LongestPathNXNMatrix();
        System.out.println(lp.maxPath(mat));
    }

    public int findLongestPath(int i ,int j ,int[][] mat, int[][] dp){
        if (i<0 || i>=N || j<0 || j>=N)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];
        //Move Up
        if(i<N-1 && (mat[i][j] + 1) == mat[i+1][j]){
            return dp[i][j] = 1 + findLongestPath(i+1, j, mat,dp);
        }
        //Move Down
        if(i>0 && (mat[i][j] + 1) == mat[i-1][j]){
            return dp[i][j] = 1 + findLongestPath(i-1, j, mat,dp);
        }
        //Move Left
        if(j>0 && (mat[i][j] + 1) == mat[i][j-1]){
            return dp[i][j] = 1 + findLongestPath(i, j-1, mat,dp);
        }
        //Move Right
        if(j<N-1 && (mat[i][j] + 1) == mat[i][j+1]){
            return dp[i][j] = 1 + findLongestPath(i, j+1, mat,dp);
        }

        return dp[i][j] = 1;
    }

    public int maxPath(int mat[][]){
        int maxPath = 1;
        int[][] result = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                result[i][j] = -1;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(result[i][j] == -1)
                    findLongestPath(i,j,mat,result);
                maxPath = Math.max(maxPath, result[i][j]);
            }
        }
        return maxPath;
    }
}
