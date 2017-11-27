package com.BinaryTree;

/**
 * Created by pjai60 on 11/14/2017.
 */
public class Node {
    Node left;
    Node right;
    int value;

    public Node(Node left, Node right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;

        Node node = (Node) o;

        if (getValue() != node.getValue()) return false;
        if (getLeft() != null ? !getLeft().equals(node.getLeft()) : node.getLeft() != null) return false;
        return getRight() != null ? getRight().equals(node.getRight()) : node.getRight() == null;
    }

    @Override
    public int hashCode() {
        int result = getLeft() != null ? getLeft().hashCode() : 0;
        result = 31 * result + (getRight() != null ? getRight().hashCode() : 0);
        result = 31 * result + getValue();
        return result;
    }
}
