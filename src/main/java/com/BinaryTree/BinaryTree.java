package com.BinaryTree;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

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

        BinaryTree binaryTree1 = new BinaryTree();
        binaryTree1.insert(10);
        binaryTree1.insert(15);
        binaryTree1.insert(8);
        binaryTree1.insert(9);
        binaryTree1.insert(7);
        binaryTree1.insert(14);

        System.out.println("***********************************************************************");
        System.out.println("PreOrder Traversal");
        binaryTree.traversePreOrder(binaryTree.root);
        System.out.println("***********************************************************************");
        System.out.println("InOrder Traversal");
        binaryTree.traverseInOrder(binaryTree.root);
        System.out.println("***********************************************************************");
        System.out.println("PostOrder Traversal");
        binaryTree.traversePostOrder(binaryTree.root);

        System.out.println("***********************************************************************");
        System.out.println("Search Value 8(exists in tree)");
        System.out.println(binaryTree.search(binaryTree.root, 8));
        System.out.println("***********************************************************************");
        System.out.println("Search Value 4(does not exists in tree)");
        System.out.println(binaryTree.search(binaryTree.root, 4));

        System.out.println("***********************************************************************");
        System.out.println("Validate Tree is same (tree is not same)");
        System.out.println(binaryTree.sameBSTree(binaryTree.root, binaryTree1.root));
        System.out.println("***********************************************************************");
        System.out.println("Add missing value 16");
        binaryTree1.insert(16);
        System.out.println("***********************************************************************");
        System.out.println("Validate Tree is same (tree is same)");
        System.out.println(binaryTree.sameBSTree(binaryTree.root, binaryTree1.root));

        System.out.println("***********************************************************************");
        System.out.println("Size of tree is (number of nodes) = " + binaryTree.size(binaryTree.root));

        System.out.println("***********************************************************************");
        System.out.println("Height of tree is = " + binaryTree.height(binaryTree.root));

        System.out.println("***********************************************************************");
        System.out.println("Max Sum of tree leaf is = " + binaryTree.maxSum(binaryTree.root));

        System.out.println("***********************************************************************");
        System.out.println("Print all Paths");
        binaryTree.printAllPaths(binaryTree.root, new int[10], 0);
        System.out.println("***********************************************************************");

        System.out.println("***********************************************************************");
        System.out.println("Print Level Order");
        binaryTree.printLevelOrder();
        System.out.println("***********************************************************************");

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

    /* Same Tree*/
    public boolean sameBSTree(Node root1, Node root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        return root1.getValue() == root2.getValue()
                && sameBSTree(root1.getLeft(), root2.getLeft())
                && sameBSTree(root1.getRight(), root2.getRight());
    }

    /* Size of Tree (Number of Nodes) */
    public int size(Node root){
        if(root == null)
            return 0;
        return (1 + size(root.getLeft()) + size(root.getRight()));

    }

    /* Height of a binary Tree*/
    public int height(Node root){
        if(root == null)
            return 0;
        return 1  + Math.max(height(root.left) , height(root.right));
    }

    /* Max Sum of a tree */
    public int maxSum(Node root){
        if(root == null)
            return 0;
        return root.getValue() + Math.max(maxSum(root.getLeft()), maxSum(root.getRight()));
    }

    /* Print Level Order */
    public void printLevelOrder(){
        Node node = this.root;
        Queue<Node> queue = new LinkedBlockingQueue<>();
        if(node == null)
            return;
        queue.add(node);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.println(temp);
            if(temp.getLeft() != null)
                queue.add(temp.getLeft());
            if(temp.getRight() != null)
                queue.add(temp.getRight());
        }
    }

    /* TODO */
    public void printZigZagLevelOrder(){
        Node node = this.root;
    }

    /* Print All Paths */
    public void printAllPaths(Node root, int[] arr, int count){
        if(root != null){
            arr[count++] = root.getValue();
            if(root.getLeft() == null && root.getRight() == null){
                for(int i = 0 ; i < count; i++)
                    System.out.print(" " + arr[i] + " ");
                System.out.println();
            }else{
                printAllPaths(root.getLeft(), arr, count);
                printAllPaths(root.getRight(), arr, count);
            }
        }
    }

    /* TODO */
    public void mirrorTree(){

    }

    /* TODO */
    public int findHeightOfElement(){
        return -1;
    }

    /* TODO Try Dijkstra Algorithm */
    public int distanceBetweenTwoNodes(){
        return -1;
    }

    /* TODO create a balanced tree from  InOrder, PreOder, PostOrder array */
    public BinaryTree createTree(int[] preOrder, int[] inOrder){
        BinaryTree binaryTree = new BinaryTree();
        return binaryTree;
    }

    /* TODO Least Common Ancestor */
    private Node getLCA(Node root, Node n1, Node n2){
        return null;
    }

    /* TODO validate tree is BST or not
    *  Inorder should be sorted array
    * */

    /* TODO check node is sibling */
    public boolean isSibling(Node root, Node node1, Node node2){
        return false;
    }

    /* TODO check node is sibling */
    public boolean isCousin(Node root, Node node1, Node node2){
        return false;
    }
}
