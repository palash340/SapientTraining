package com.AmazonInterview;

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

        return 0;
    }
}
