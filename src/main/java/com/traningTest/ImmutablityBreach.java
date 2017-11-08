package com.traningTest;

import java.util.Random;

/**
 * Created by pjai60 on 11/7/2017.
 */
public class ImmutablityBreach extends TestC
{
    public ImmutablityBreach(int val) {
        super(val);
    }

    @Override
    public int getVal() {
        return new Random().nextInt();
    }

    public static void main(String[] args) {
        TestC c1 = new ImmutablityBreach(10);

        System.out.println(c1.getVal());
        System.out.println(c1.getVal());
        System.out.println(c1.getVal());

        System.out.println(c1.toString());
        System.out.println(c1.toString());
        System.out.println(c1.toString());
    }

    public void addToMap(TestC val){
        //add to map
    }
}

class TestC{
    private final int val;

    TestC(int val){
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestC)) return false;

        TestC testC = (TestC) o;

        return getVal() == testC.getVal();
    }


    @Override
    public int hashCode() {
        return 31 * getVal();
    }
}
