package com.PatternMatching;

/**
 * Created by Palash on 10/31/2017.
 * Knuth–Morris–Pratt(KMP) Pattern Matching(Substring search)
 */
public class KMPAlgorithm {
    public static void main(String[] args) {
        KMPAlgorithm kmp = new KMPAlgorithm();
        //int[] arr = kmp.tempArray("aabaabaaa");
        System.out.println(kmp.KMP("abcdabca", "abckkabcdkkabcdfabca"));
    }

    public boolean KMP(String pattern, String text){
        char[] charArray = pattern.toCharArray();
        char[] textArray = text.toCharArray();
        int[] arr = tempArray("abcdabca".toCharArray());
        int i=0,j=0;
        while(i < textArray.length && j < charArray.length){
            if(charArray[i] == textArray[j]){
                i++;
                j++;
            }else{
                if(j != 0){
                    j = arr[j-1];
                }else{
                    i++;
                }
            }
            if(j == charArray.length)
                return true;
        }
        return false;
    }



    public int[] tempArray(char[] charArr){

        int[] intArray = new int[charArr.length];
        int i = 1, j = 0;
        intArray[0] = 0;
        while (i < charArr.length){
            if(charArr[i] == charArr[j]){
                intArray[i] = ++j;
                i++;
            }else{
                if(j != 0){
                    j = intArray[j-1];
                }else{
                    intArray[i] = 0;
                    i++;
                }
            }
        }
        return intArray;
    }
}
