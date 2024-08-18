package com.venkat.alog.sv;

public class Deque {
    private Node head;
    private Node tail;
    private int size;


    private static class Node{
        Object data;
        Node next;
        Node prev;
        Node(Object data){
            this.data = data;
        }
    }
    public Deque() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public void addFirst(Object data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        }else{
            newNode.next =  head;

        }
    }
}
