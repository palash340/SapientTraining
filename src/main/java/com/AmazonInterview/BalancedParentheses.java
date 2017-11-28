package com.AmazonInterview;

import java.util.Stack;

/**
 * Created by pjai60 on 11/28/2017.
 */
public class BalancedParentheses {
    public static void main(String[] args) {
        BalancedParentheses bp = new BalancedParentheses();
        System.out.println(bp.isBalanced("((){})".toCharArray()));
    }

    public boolean isBalanced(char[] arr){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '{' || arr[i] == '(' || arr[i] == '[')
                stack.push(arr[i]);
            if(arr[i] == '}' || arr[i] == ')' || arr[i] == ']'){
                if(stack.isEmpty())
                    return false;
                if(!isMatchingPair(stack.pop(), arr[i]))
                    return false;
            }
        }
        return stack.isEmpty();
    }


    public boolean isMatchingPair(char opening, char closing){
        if(opening == '(' && closing == ')')
            return true;
        if(opening == '{' && closing == '}')
            return true;
        if(opening == '[' && closing == ']')
            return true;
        return false;
    }
}
