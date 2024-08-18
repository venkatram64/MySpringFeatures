package com.venkat.alog.sv;

public class MyDeque {
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
    public MyDeque(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public void addFirst(Object data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;

        }
        size++;
    }
    public void addLast(Object data){
        Node newNode = new Node(data);
        if(tail == null){
            head = tail = newNode;
        }else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    public static void main(String[] args){
        MyDeque deque = new MyDeque();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);
    }
}
