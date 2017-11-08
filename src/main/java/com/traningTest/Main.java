package com.traningTest;

import java.util.Objects;

/**
 * Created by pjai60 on 11/7/2017.
 */
public class Main {
    static void m1(AA a){
        System.out.println("A");
    }
    static void m1(BB a){
        System.out.println("B");
    }
    static void m1(Object c){
        System.out.println("Object");
    }

    public static void main(String[] args) {
        m1(new CC());
    }
}

class AA{

}
class BB extends AA{

}

class CC extends BB{

}
