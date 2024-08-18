package com.venkat.alog.binary;

public class TreeComparision<T extends Comparable<T>> {

    //DFS
    public boolean isTreeSame(Node<T> node1, Node<T> node2){
        //case when one of the nodes is a null or both of them
        //check topology
        if((node1 == null && node2 == null) || (node1 == null && node2 != null)
                || (node1 != null && node2 == null)){
            return node1 == node2;
        }
        //check the values
        if(node1.getData().compareTo(node2.getData()) != 0){
            return false;
        }
        //consider other nodes recursively
        return isTreeSame(node1.getLeftChild(), node2.getLeftChild()) &&
                isTreeSame(node1.getRightChild(), node2.getRightChild());
    }

    public static void main(String[] args) {

        Tree<Integer> bst1 = new BinarySearchTree<>();
        bst1.insert(10);
        bst1.insert(5);
        bst1.insert(20);
        bst1.insert(1);

        Tree<Integer> bst2 = new BinarySearchTree<>();
        bst2.insert(10);
        bst2.insert(5);
        bst2.insert(25);
        bst2.insert(1);
        TreeComparision<Integer> tc = new TreeComparision<>();
        System.out.println(tc.isTreeSame(bst1.getRoot(), bst2.getRoot()));
    }
}
