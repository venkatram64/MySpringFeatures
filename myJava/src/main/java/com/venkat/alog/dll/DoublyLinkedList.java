package com.venkat.alog.dll;

public class DoublyLinkedList<T extends Comparable<T>> {

    private Node<T> head;
    private Node<T> tail;

    public void insert(T data){
        Node<T> newNode = new Node<>(data);
        if(tail == null){
            tail = newNode;
            head = newNode;
        }else{
            newNode.setPrevNode(tail);
            tail.setNextNode(newNode);
            tail = newNode;
        }
    }

    public void traverseForward(){
        Node<T> actualNode = head;
        while(actualNode != null){
            System.out.print(actualNode);
            actualNode = actualNode.getNextNode();
        }
    }

    public void traverseBackward(){
        Node<T> actualNode = tail;
        while(actualNode != null){
            System.out.print(actualNode);
            actualNode = actualNode.getPrevNode();
        }
    }
}
