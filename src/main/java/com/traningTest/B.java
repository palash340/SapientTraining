package com.traningTest;

/**
 * Created by pjai60 on 11/7/2017.
 */
public class B extends A {
    static {
        System.out.println("4");
    }
    {
        System.out.println("5");
    }
    B(){
        System.out.println("6");
    }

    public static void main(String[] args) {
        B b = new B();
    }
}
 class A{
    static {
        System.out.println("1");
    }
    {
        System.out.println("2");
    }
    A(){
        System.out.println("3");
    }
}
