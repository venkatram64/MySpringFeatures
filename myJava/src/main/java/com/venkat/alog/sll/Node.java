package com.venkat.alog.sll;

public class Node<T extends Comparable<T>> {

    private T data;
    private Node<T> next;

    public Node(T data){
        this.data = data;
    }

    public void setData(T data){
        this.data = data;
    }

    public T getData(){
        return this.data;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public Node<T> getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                "}->";
    }
}
