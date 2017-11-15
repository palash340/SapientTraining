package com.traningTest;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pjai60 on 11/8/2017.
 */
public class StackUsingQueue
{
    Queue<String> queue = new LinkedList<>();

    public void pop(){

    }

    public void push(String value){
        queue.add(value);
    }
}
