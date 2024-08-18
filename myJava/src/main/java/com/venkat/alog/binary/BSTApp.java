package com.venkat.alog.binary;

public class BSTApp {

    public static void main(String[] args) {
        buildBST1();
        buildBST2();
    }

    private static void buildBST2() {
        System.out.println("Testing...");
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(12);
        bst.insert(4);
        bst.insert(20);
        bst.insert(1);
        bst.insert(8);
        bst.insert(16);
        bst.insert(27);

        bst.remove(16);
        bst.remove(20);
        bst.remove(12);

        System.out.println("\n In Order");
        bst.inOrderTraversal();
        System.out.println("\n Pre Order");
        bst.preOrderTraversal();
        System.out.println("\n Post Order");
        bst.postOrderTraversal();

        System.out.println();
        System.out.println(bst.getMax());
        System.out.println(bst.getMin());
    }

    private static void buildBST1() {
        System.out.println("Testing...");
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(3);
        bst.insert(7);
        bst.insert(8);
        bst.insert(4);
        bst.insert(5);
        bst.insert(2);
        System.out.println("\n In Order");
        bst.inOrderTraversal();
        System.out.println("\n Pre Order");
        bst.preOrderTraversal();
        System.out.println("\n Post Order");
        bst.postOrderTraversal();

        System.out.println();
        System.out.println(bst.getMax());
        System.out.println(bst.getMin());
    }
}
