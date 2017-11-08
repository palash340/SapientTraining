package com.traningTest;

/**
 * Created by pjai60 on 11/7/2017.
 */
public class PassByValue {
    // It doesn't work because it pass by value
    // so reference variable swap1 and swap2 will be local to the method
    public void swap(A1 swap1, A1 swap2){
        A1 temp = swap1;
        swap1 = swap2;
        swap2 = temp;
    }

    public static void main(String[] args) {
        A1 a1 = new A1(1);
        A1 a2 = new A1(2);

        //Before Swap
        System.out.println(a1.i);
        System.out.println(a2.i);

        PassByValue pv = new PassByValue();
        pv.swap(a1,a2);

        //After Swap
        System.out.println(a1.i);
        System.out.println(a2.i);
    }
}
class A1{
    int i;
    public A1(int i){
        this.i = i;
    }
}
