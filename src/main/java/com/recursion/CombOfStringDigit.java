package com.recursion;

/*
*   Given an input string of numbers, find all combinations of numbers that can be formed using digits in the same order.
    Examples:

    Input : 123
    Output :1 2 3
            1 23
            12 3
            123

    Input : 1234
    Output : 1 2 3 4
            1 2 34
            1 23 4
            1 234
            12 3 4
            12 34
            123 4
            1234
*/
public class CombOfStringDigit {
    public static void main(String[] args) {
        CombOfStringDigit cg = new CombOfStringDigit();
        //cg.printAllComb("1234",0,"");
        cg.printAllComb("1234",0,new char[4*2+1], 0);
    }

    public void printAllComb(String input, int inputIndex, String output){
        if(inputIndex >= input.length()) {
            System.out.println(output);
            return;
        }

        // Print without space
        output += input.charAt(inputIndex);
        inputIndex++;
        printAllComb(input, inputIndex, output);
        // Print with space
        if(inputIndex != input.length()) {
            output += ' ';
            printAllComb(input, inputIndex, output);
        }
    }

    public void printAllComb(String input, int inputIndex, char[] output, int outputIndex){
        if(inputIndex >= input.length()) {
            System.out.println(output);
            return;
        }

        // Print without space
        output[outputIndex] = input.charAt(inputIndex);
        inputIndex++;
        outputIndex++;

        printAllComb(input, inputIndex, output, outputIndex);
        // Print with space
        if(inputIndex != input.length()) {
            output[outputIndex] = ' ';
            outputIndex++;
            printAllComb(input, inputIndex, output, outputIndex);
        }
    }
}
