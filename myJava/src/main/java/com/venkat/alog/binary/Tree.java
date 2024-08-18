package com.venkat.alog.binary;

public interface Tree<T> {
    Node<T> getKSmallest(Node<T> node, int k);
    Node<T> getRoot();
    void insert(T data);
    void remove(T data);
    //in-order traversal yields the natural ordering
    void inOrderTraversal();
    //pre-order traversal
    void preOrderTraversal();
    //post-order traversal
    void postOrderTraversal();
    T getMin();
    T getMax();
    int getTotalAge(Node<T> node);
}
