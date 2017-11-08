package com.assignment.fibonacci;

/**
 * Created by pjai60 on 11/6/2017.
 */
public class getNthElement {
    public static void main(String[] args) {
        getNthElement n = new getNthElement();
        System.out.println(n.getValue(4));
    }

    public int getValue(int count){
        if(count == 0 || count == 1)
            return 1;
        return getValue(count-2) + getValue(count -1);
    }
}
