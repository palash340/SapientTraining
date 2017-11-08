package com.traningTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by pjai60 on 11/8/2017.
 */
public class ListIteratorDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println("Val = " +iterator.next());
           // list.add("4");
        }

        List<String> clist = new CopyOnWriteArrayList<>();
        clist.add("1");
        clist.add("2");
        clist.add("3");

        Iterator<String> iterator1 = clist.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator.next());
            iterator1.remove();
        }

    }
}
