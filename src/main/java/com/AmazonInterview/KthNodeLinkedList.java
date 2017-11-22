package com.AmazonInterview;

import java.util.Stack;

/**
 * Created by pjai60 on 11/16/2017.
 */
public class KthNodeLinkedList {
    Node root;
    public static void main(String[] args) {
        KthNodeLinkedList list = new KthNodeLinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.addNode(6);
        list.addNode(7);
        list.addNode(8);

        //reorder list with kth
        list.reorderKthNode(4);
    }

    public void addNode(int val){
        Node node = new Node(null, val);
        if(this.root == null){
            this.root = node;
            return;
        }
        // Go to end node
        Node currentNode = this.root;
        while(currentNode.getNext() != null){
            currentNode = currentNode.getNext();
        }
        // Add node to current node
        currentNode.setNext(node);
    }

    public void reorderKthNode(int k){
        Node node = this.root;
        Stack<Node> stack = new Stack<>();
        boolean isfirst = true;
        Node lastNode  = null;
        while(node != null) {
            if (stack.size() == k) {
                boolean isFirstPop = true;
                Node tempNode = stack.pop();
                if(isfirst && isFirstPop){
                    isfirst = false;
                    isFirstPop = false;
                    this.root = tempNode;
                }
                if(isFirstPop){
                    isFirstPop = false;
                    lastNode.setNext(tempNode);
                }
                while (stack.size() != 0) {
                    Node test = stack.pop();
                    tempNode.setNext(test);
                    tempNode = test;
                }
                lastNode = tempNode;
            }
            stack.push(node);
            node = node.getNext();
        }

        boolean isFirstPop = true;
        while (stack.size() != 0) {
            Node testNode = stack.pop();
            if(isFirstPop){
                isFirstPop =false;
                lastNode.setNext(testNode);
            }else{
                lastNode.setNext(testNode);
            }
            lastNode = testNode;
        }
        lastNode.setNext(null);
        printList();
    }

    public void printList(){
        System.out.println("KthNodeLinkedList.printList");
        Node node = this.root;
        while(node != null){
            System.out.println(node.getValue());
            node = node.getNext();
        }
        System.out.println("KthNodeLinkedList.printList");
    }

    private void reverse(Node node, Node previousNode){
        if(node == null){
            this.root = previousNode;
        }else{
            reverse(node.getNext(), node);
            node.setNext(previousNode);
        }
    }
}

class Node{
    Node next;
    int value;

    public Node(Node next, int value) {
        this.next = next;
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
