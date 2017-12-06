package com.BinaryTree;

import com.assignment.Emp;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by pjai60 on 11/14/2017.
 */
public class BinaryTree {
    Node root;

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
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

        System.out.println("***********************************************************************");
        System.out.println("Print ZigZag Level Order");
        binaryTree.printZigZagLevelOrder();
        System.out.println("***********************************************************************");


        System.out.println("***********************************************************************");
        System.out.println("Create Binary Tree from Pre and In Order");
        int[] preOrder = {10, 8, 7, 9, 15, 14, 16};
        int[] inOrder = {7, 8, 9, 10, 14, 15, 16};
        binaryTree.createTree(preOrder, inOrder);

        System.out.println("***********************************************************************");
        System.out.println("Original  Tree");
        binaryTree.printLevelOrder();
        System.out.println();
        System.out.println("Mirror Tree");
        binaryTree.mirrorTree();
        binaryTree.printLevelOrder();
        System.out.println("***********************************************************************");


        System.out.println("Find LCA");
        Node node = binaryTree.getLCA(binaryTree.root, 8, 15);
        System.out.println(node);
        node = binaryTree.getLCA(binaryTree.root, 8, 15);
        System.out.println(node);
        System.out.println("***********************************************************************");

        System.out.println(binaryTree1.isComplete(binaryTree1.root));
        binaryTree1.insert(10);
        System.out.println("--------");
        System.out.println(binaryTree1.isComplete(binaryTree1.root));
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

    /*
        1. Keep iterating and comparing tree recursively
        2. Compare pre order and in order traversal if equal then tree is equal
    */
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

    /* Print ZigZag Level Order */
    public void printZigZagLevelOrder(){
        Node node = this.root;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        // Add root element
        stack1.push(node);
        printZigZag(stack1, stack2, true);
    }

    private void printZigZag(Stack<Node> stack1, Stack<Node> stack2, boolean isEvenLevel){
        while(!stack1.isEmpty()){
            Node node = stack1.pop();
            System.out.println(node);
            Node left = node.getLeft();
            Node right = node.getRight();
            if(isEvenLevel){
                if(left != null)
                    stack2.add(node.getLeft());
                if(right != null)
                    stack2.add(node.getRight());
            }else{
                if(right != null)
                    stack2.add(node.getRight());
                if(left != null)
                    stack2.add(node.getLeft());
            }
        }
        if(!stack2.isEmpty())
            printZigZag(stack2, stack1, !isEvenLevel);

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

    /* Mirror Tree */
    public void mirrorTree(){
        mirrorTree(this.root);
    }

    private Node mirrorTree(Node node){
        if(node == null)
            return node;
        Node left = mirrorTree(node.getLeft());
        Node right = mirrorTree(node.getRight());

        node.setRight(left);
        node.setLeft(right);
        return node;
    }

    /* TODO */
    public int findHeightOfElement(){
        return -1;
    }

    /* TODO Try Dijkstra Algorithm */
    public int distanceBetweenTwoNodes(){
        return -1;
    }

    /* TODO create a balanced tree from  InOrder & PreOder, PostOrder array */
    public BinaryTree createTree(int[] preOrder, int[] inOrder){
        BinaryTree binaryTree = new BinaryTree();
        Node node = null;
        binaryTree.root = node;
        for(int i = 0; i < preOrder.length; i++){
            node = new Node(null, null, preOrder[i]);

        }
        return binaryTree;
    }

    private int search(int[] inOrder, int start, int end, int nodeValue){
        if(start == end){
            return -1;
        }
        for(int i = start; i <= end; i++){
            if(nodeValue == inOrder[i])
                return i;
        }
        return -1;
    }

    /* TODO Least Common Ancestor */
    private Node getLCA(Node root, int value1, int value2){
        return null;
    }

    /* TODO validate tree is BST or not
    *  Inorder should be sorted array
    * */

    /* TODO check node is sibling */
    public boolean isSibling(Node root, Node node1, Node node2){
        return false;
    }

    /* TODO check node is Cousin */
    public boolean isCousin(Node root, Node node1, Node node2){
        return false;
    }


    public boolean isComplete(Node root){
        if(root == null)
            return true;
        int size = size(root);

        ArrayList<NodeWithIndex> arrayList = new ArrayList<>();
        getArrayList(arrayList,0, root);
        int max = -1;
        for (NodeWithIndex nodeW: arrayList) {
            if(max < nodeW.index)
                max = nodeW.index;
        }
        return max+1 == size;
    }

    private void getArrayList(ArrayList<NodeWithIndex> arrayList, int level, Node node){
        NodeWithIndex nodeWithIndex = new NodeWithIndex(node, level);
        arrayList.add(nodeWithIndex);
        if(node.getLeft() != null)
            getArrayList(arrayList, 2*level + 1, node.getLeft());
        if(node.getRight() != null)
            getArrayList(arrayList, 2*level + 2, node.getRight());
    }
}

class NodeWithIndex{
    Node node;
    int index;

    public NodeWithIndex(Node node, int index) {
        this.node = node;
        this.index = index;
    }

    @Override
    public String toString() {
        return "NodeWithIndex{" +
                "node=" + node +
                ", index=" + index +
                '}';
    }
}
