package com.venkat.interview;

public class ArrayDeque<T> {

    private T[] array;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ArrayDeque(){
        this(10);
    }

    @SuppressWarnings("unchecked")
    public ArrayDeque(int initialCapacity){
        this.capacity = initialCapacity;
        array = (T[]) new Object[initialCapacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    public void resize(int newCapacity){
        T[] newArray = (T[]) new Object[newCapacity];
        for(int i = 0; i < size; i++){
            newArray[i] = array[(front + i) % capacity];
        }
        array = newArray;
        front = 0;
        rear = size - 1;
        capacity = newCapacity;
    }

    public void addFirst(T data){
        if(isFull()){
            resize(capacity * 2);
        }
        if(isEmpty()){
            front = rear = 0;
        }else{
            front = (front - 1 + capacity) % capacity;
        }
        array[front] = data;
        size++;
    }

    public void addLast(T data){
        if(isFull()){
            resize(capacity * 2);
        }
        if(isEmpty()){
            front = rear = 0;
        }else{
            rear = (rear + 1) % capacity;
        }
        array[rear] = data;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        T data = array[front];
        if (front == rear) {
            front = rear = -1;
        } else{
            front = (front + 1) % capacity;
        }
        size--;
        if(size > 0 && size == capacity/4){
            resize(capacity/2);
        }
        return data;
    }

    public T removeLast(){
        if(isEmpty()){
            throw new IllegalStateException("Deque is empty");
        }
        T data = array[rear];
        if(front == rear){
            front = rear = -1;
        }else{
            rear = (rear - 1 + capacity) % capacity;
        }
        size--;
        if(size > 0 && size == capacity/4){
            resize(capacity/2);
        }
        return data;
    }

    public T peekFirst(){
        if(isEmpty()){
            throw new IllegalStateException("Deque is empty");
        }
        return array[front];
    }

    public T peekLast(){
        if(isEmpty()){
            throw new IllegalStateException("Deque is empty");
        }
        return array[rear];
    }

    public void printFromFront(){
        if(isEmpty()){
            System.out.println("Deque is empty");
            return;
        }
        System.out.println("Deque from front:");
        for(int i = 0; i < size; i++){
            System.out.print(array[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public void printFromRear(){
        if(isEmpty()){
            System.out.println("Deque is empty");
            return;
        }
        System.out.println("Deque from rear:");
        for(int i = 0; i < size; i++){
            System.out.print(array[(rear - i + capacity) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);

        deque.printFromFront();
        deque.printFromRear();

        System.out.println("First element: " + deque.peekFirst()); // Output: 2
        System.out.println("Last element: " + deque.peekLast());   // Output: 4

        System.out.println("Removed first element: " + deque.removeFirst()); // Output: 2
        System.out.println("Removed last element: " + deque.removeLast());   // Output: 4
        System.out.println("First element after removal: " + deque.peekFirst()); // Output: 1
        System.out.println("Last element after removal: " + deque.peekLast());   // Output: 3

        deque.addFirst(5);
        deque.addLast(6);

        System.out.println("First element: " + deque.peekFirst()); // Output: 5
        System.out.println("Last element: " + deque.peekLast());   // Output: 6
    }
}
