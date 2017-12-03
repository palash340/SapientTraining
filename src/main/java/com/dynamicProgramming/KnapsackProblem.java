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
        System.out.println(kp.buildMatrix(weightArr, valArr, 7));
        System.out.println(kp.knapsackWithRec(weightArr,valArr,7,0));

    }

    public int buildMatrix(int[] weightArr, int[] valArr, int maxWeight){
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
        //System.out.println(Arrays.deepToString(matrix));
        return findMax(matrix);
    }


    //TODO code is not working correctly
    public int knapsackWithRec(int[] weight, int[] val, int w, int itemNum){
        if(w == 0 || itemNum == weight.length)
            return 0;
        // Item weight is greater than expected (don't pick item)
        if(weight[itemNum] > w)
            knapsackWithRec(weight,val,w,itemNum+1);
        // Pick the item
        int rMax = val[itemNum] + knapsackWithRec(weight, val, w - weight[itemNum], itemNum+1);
        // Don't pick item
        int lMax = knapsackWithRec(weight,val, w, itemNum+1);

        return Math.max(rMax, lMax);
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
