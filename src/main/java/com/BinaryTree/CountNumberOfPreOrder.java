package com.BinaryTree;

/**
 * Created by pjai60 on 11/27/2017.
 */
public class CountNumberOfPreOrder {
    public int countPreOrder(int num){
        if(num == 0 || num == 1)
            return 1;
        int[] T = new int[num+1];
        T[0] = 1;
        T[1] = 1;

        for (int i = 2; i <= num; i++) {
            int sum = 0 ;
            for (int j = 0; j < i ; j++) {
                sum += T[j] * T[i-j-1];
            }
            T[i] = sum;
        }
        return T[num];
    }

    public int countPreOrderRec(int num){
        if(num == 0 || num == 1)
            return 1;
        int sum = 0;
        for (int i = 1; i <= num ; i++)
            sum += countPreOrderRec(i-1) * countPreOrderRec(num - i);
        return sum;
    }

    public static void main(String[] args) {
        CountNumberOfPreOrder countNumberOfPreOrder = new CountNumberOfPreOrder();
        System.out.println(countNumberOfPreOrder.countPreOrder(5));
        System.out.println(countNumberOfPreOrder.countPreOrderRec(5));
    }


}
