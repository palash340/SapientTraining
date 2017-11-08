package com.RecursiveSolving;

/**
 * Created by pjai60 on 11/6/2017.
 */
public class ReverseLinkedList {
    ReverseLinkedListNode root = null;
    public static void main(String[] args) {
        ReverseLinkedList rList =  new ReverseLinkedList();
        rList.root = new ReverseLinkedListNode(1, null);
        ReverseLinkedListNode ele1 = new ReverseLinkedListNode(2, null);
        rList.root.setNext(ele1);
        ReverseLinkedListNode ele2 = new ReverseLinkedListNode(3, null);
        ele1.setNext(ele2);
        ReverseLinkedListNode ele3 = new ReverseLinkedListNode(4, null);
        ele2.setNext(ele3);

        //print once
        System.out.println(rList.root.getValue());
        System.out.println(rList.root.getNext().getValue());
        System.out.println(rList.root.getNext().getNext().getValue());
        System.out.println(rList.root.getNext().getNext().getNext().getValue());

        rList.reverseList(rList.root , null);


        System.out.println("Reverse");

        //print once
        System.out.println(rList.root.getValue());
        System.out.println(rList.root.getNext().getValue());
        System.out.println(rList.root.getNext().getNext().getValue());
        System.out.println(rList.root.getNext().getNext().getNext().getValue());
    }

    public void reverseList(ReverseLinkedListNode node, ReverseLinkedListNode previousNode){
        if(node == null){
            this.root = previousNode;
        }else{
            reverseList(node.getNext(), node);
            node.setNext(previousNode);
        }
    }
}


class ReverseLinkedListNode{
    private int value;
    private ReverseLinkedListNode next;

    public ReverseLinkedListNode(int value,ReverseLinkedListNode next){
        this.setValue(value);
        this.setNext(next);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ReverseLinkedListNode getNext() {
        return next;
    }

    public void setNext(ReverseLinkedListNode next) {
        this.next = next;
    }
}