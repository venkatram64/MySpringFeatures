package com.venkat.interview;

public class Deque<T> {

    private Node<T> front;
    private Node<T> rear;
    private int size;

    private static class Node<T>{
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public Deque(){
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void addFirst(T data){
        Node<T> newNode = new Node<>(data);
        if(isEmpty()){
            //new node address is stored in front and rear
            front = rear = newNode;
        }else{
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        size++;
    }

    public void addLast(T data){
        Node<T> newNode = new Node<>(data);
        if(isEmpty()){
            //new node address is stored in front and rear
            front = rear = newNode;
        }else{
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public T removeFirst(){
        if(isEmpty()){
            throw new IllegalStateException("Deque is empty");
        }
        T data = front.data;
        front = front.next;
        if(front != null){
            front.prev = null;
        }else{
            rear = null;
        }
        size--;
        return data;
    }

    public T removeLast(){
        if(isEmpty()){
            throw new IllegalStateException("Deque is empty");
        }
        T data = rear.data;
        rear = rear.prev;
        if(rear != null){
            rear.next = null;
        }else{
            front = null;
        }
        size--;
        return data;
    }

    public T peekFirst(){
        if(isEmpty()){
            throw new IllegalStateException("Deque is empty");
        }
        return front.data;
    }

    public T peekLast(){
        if(isEmpty()){
            throw new IllegalStateException("Deque is empty");
        }
        return rear.data;
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();

        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(0);
        System.out.println("First element: " + deque.peekFirst()); // Output: 0
        System.out.println("Last element: " + deque.peekLast());  // Output: 2

        System.out.println("Removed first element: " + deque.removeFirst()); // Output: 0
        System.out.println("Removed last element: " + deque.removeLast());  // Output: 2
        System.out.println("Size: " + deque.size()); // Output: 1
    }
}
