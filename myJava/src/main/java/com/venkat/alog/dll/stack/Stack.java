package com.venkat.alog.dll.stack;

public class Stack<T> {

    private Node<T> head;
    private int count;

    public T pop(){
        if(isEmpty()){
            return null;
        }
        T item = head.getData();
        head = head.getNextNode();
        count--;
        return item;
    }

    public void push(T data){
        count++;
        if(head == null){
            head = new Node(data);
        }else{
            Node<T> oldHead = head;
            head = new Node<>(data);
            head.setNextNode(oldHead);
        }
    }


    public T peek(){
        if(isEmpty()){
            return null;
        }
        return head.getData();
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public void traverse(){
        Node<T> current = head;
        while(current != null){
            System.out.print(current + "  ");
            current = current.getNextNode();
        }
    }
}
