package com.recursion;

/*
* Count the number of Binary Tree possible for a given Preorder Sequence length n.
*
    Example

    Input : n = 1
    Output : 1

    Input : n = 2
    Output : 2

    Input : n = 3
    Output : 5
*/
public class BTFromPreOrder {
    public static void main(String[] args) {
        System.out.println(countBTDP(5));
        System.out.println(countBTRec(5));
    }

    public static int countBTRec(int n){
        if(n == 0 || n == 1)
            return 1;
        return countBTRec(n-1) * countBTRec(n-2);
    }

    public static  int countBTDP(int n){
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                arr[i] += arr[j] * arr[i-j-1];
            }
        }
        return arr[n];
    }
}
