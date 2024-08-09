package com.venkat.alog.dll.que;

public class Queue<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int count;

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return this.firstNode == null;
    }

    //always manipulate the lastNode
    public void enqueue(T data){
        Node<T> oldLastNode = this.lastNode;
        this.lastNode = new Node<>(data);
        //5 <- 3 <- 2
        if(isEmpty()){
            //beginning of the queue
            this.firstNode = this.lastNode;
        }else{
            oldLastNode.setNextNode(this.lastNode);
        }
        count++;
    }

    //always manipulate the firstNode
    public T dequeue(){
        if(isEmpty()){
            return null;
        }
        count--;
        T dataToRemove = this.firstNode.getData();
        this.firstNode = this.firstNode.getNextNode();
        if(isEmpty()){
            this.lastNode = null;
        }
        return dataToRemove;
    }

    public void traverse(){
        Node<T> current = this.firstNode;
        while(current != null){
            System.out.print(current);
            current = current.getNextNode();
        }
    }
}
