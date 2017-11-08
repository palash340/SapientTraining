package com.dynamicProgramming;

import java.util.Arrays;

/**
 * Created by pjai60 on 11/6/2017.
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        KnapsackProblem kp = new KnapsackProblem();
        int[] valArr = {1,4,5,7};
        int[] weightArr = {1,3,4,5};
        kp.buildMatrix(weightArr, valArr, 7);

    }

    public void buildMatrix(int[] weightArr, int[] valArr, int maxWeight){
        int[][] matrix = new int[valArr.length][maxWeight+1];
        //initialize zeroth column
        for(int i = 0; i < valArr.length ; i++)
            matrix[i][0] = 0;
        //fill the matrix
        int row = 0;
        while(row < valArr.length){
            for(int column = 1; column <= maxWeight; column++){
                if(column >= weightArr[row]){
                    if(row == 0 )
                        matrix[row][column] = valArr[row];
                    else
                        matrix[row][column] = Math.max(valArr[row] + matrix[row-1][column - weightArr[row]], matrix[row-1][column - weightArr[row]]);
                }
            }
            row++;
        }
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(matrix.toString());
    }


}
