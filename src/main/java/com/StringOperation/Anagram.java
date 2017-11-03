package com.StringOperation;

/**
 * Created by pjai60 on 11/3/2017.
 */
public class Anagram {
    public static void main(String[] args) {
        Anagram ana = new Anagram();
        String anagram = "abcd";
        char[] arr = anagram.toCharArray();
        ana.permute(arr, 0, arr.length - 1);
    }

    public void permute(char[] text, int i, int j){
        if(i == j )
            System.out.println(String.valueOf(text));
        else{
            for (int k = i; k <= j; k++){
                swap(text, k, i);
                permute(text, i+1, j);
                swap(text, k, i);
            }
        }
    }

    public void swap(char[] text,int index, int swapIndex){
        char temp = text[index];
        text[index] = text[swapIndex];
        text[swapIndex] = temp;
    }

}

