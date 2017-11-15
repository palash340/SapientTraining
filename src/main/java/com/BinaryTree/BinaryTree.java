package com.BinaryTree;

/**
 * Created by pjai60 on 11/14/2017.
 */
public class BinaryTree {
    Node root;

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(10);
        binaryTree.insert(15);
        binaryTree.insert(8);
        binaryTree.insert(9);
        binaryTree.insert(7);
        binaryTree.insert(14);
        binaryTree.insert(16);

        System.out.println(binaryTree.root);
        System.out.println("PreOrder Traversal");
        binaryTree.traversePreOrder(binaryTree.root);
        System.out.println("InOrder Traversal");
        binaryTree.traverseInOrder(binaryTree.root);
        System.out.println("PostOrder Traversal");
        binaryTree.traversePostOrder(binaryTree.root);

        System.out.println("Search Value 8(exists in tree)");
        System.out.println(binaryTree.search(binaryTree.root, 8));
        System.out.println("Search Value 4(does not exists in tree)");
        System.out.println(binaryTree.search(binaryTree.root, 4));
    }

    /* PreOrder Traversal*/
    public void traversePreOrder(Node node){
        if(node != null){
            System.out.println(node.getValue());
            traversePreOrder(node.getLeft());
            traversePreOrder(node.getRight());
        }
    }

    /* InOrder Traversal*/
    public void traverseInOrder(Node node){
        if(node != null){
            traverseInOrder(node.getLeft());
            System.out.println(node.getValue());
            traverseInOrder(node.getRight());
        }
    }

    /* PostOrder Traversal*/
    public void traversePostOrder(Node node){
        if(node != null){
            traversePostOrder(node.getLeft());
            traversePostOrder(node.getRight());
            System.out.println(node.getValue());
        }
    }

    /* Insert to Binary Search Tree*/
    public void insert(int value){
        Node node = this.root;
        if(node == null){
            this.root = new Node(null, null, value);
            return;
        }
        while(true){
            if(value > node.getValue()){
                if(node.getRight() != null){
                    node = node.getRight();
                }else{
                    node.setRight(new Node(null, null, value));
                    break;
                }
            }else{
                if(node.getLeft() != null){
                    node = node.getLeft();
                }else {
                    node.setLeft(new Node(null, null, value));
                    break;
                }
            }
        }
    }

    public Node search(Node node, int value){
        if(node == null)
            return null;
        if(node.getValue() == value)
            return node;
        if(value > node.getValue()){
            return search(node.getRight(), value);
        }else{
            return search(node.getLeft(), value);
        }
    }
}
