package com.AmazonInterview;

/**
 * Created by pjai60 on 12/2/2017.
 */
/*
* Find all even length binary sequences with same sum of first and second half bits
* Given a number n, find all binary sequences of length 2n such that sum of first n bits is same as sum of last n bits.
* Examples:
*   Input:  N = 2
    Output:
        0101 1111 1001 0110 0000 1010

    Input:  N = 3
    Output:
        011011 001001 011101 010001 101011 111111
        110011 101101 100001 110101 001010 011110
        010010 001100 000000 010100 101110 100010
        110110 100100
*/
public class BinarySequenceSame {
    private static final int N = 3;
    public static void main(String[] args) {
        BinarySequenceSame binarySequenceSame = new BinarySequenceSame();

        char[] arr = new char[2*N];
        binarySequenceSame.printAllBinarySeq(0, arr, 0, arr.length -1);
    }

    public void printAllBinarySeq(int diff, char[] arr, int start, int end){
        // We can't cover difference of more
        // than n with 2n bits
        if(Math.abs(diff) > (end - start + 1) / 2 )
            return;

        // Print or return if all bits are filled
        if(start > end){
            // If first n and last n bit are same the print
            if(diff  == 0 )
                System.out.println(arr);
            return;
        }

        // fill first bit as 0 and last bit as 1
        arr[start] = '0';
        arr[end] = '1';
        printAllBinarySeq(diff + 1, arr, start +1, end -1);

        // fill first and last bit with 1
        arr[start] = arr[end] = '1';
        printAllBinarySeq(diff, arr, start+1, end -1);

        // fill first and last bit with 1
        arr[start] = arr[end] = '0';
        printAllBinarySeq(diff, arr, start+1, end -1);

        // fill first bit as 1 and last bit as 0
        arr[start] = '1';
        arr[end] = '0';
        printAllBinarySeq(diff - 1, arr, start +1, end -1);

    }
}
