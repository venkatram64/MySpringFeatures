package com.venkat.alog.dll.q;

import java.util.Stack;

/*
The problem is that we want to implement queue abstract data type with the
enqueue() and dequeue() operations with stacks
we can use 2 stacks to solve this problem
one stack: for enqueue() operation
one stack: for dequeue() operation
 */
public class MyQueue {

    //use one stack for enqueue operation
    private Stack<Integer> enqueueStack;
    //use another stack for the dequeue operation
    private Stack<Integer> dequeueStack;

    public MyQueue(){
        this.enqueueStack = new Stack<>();
        this.dequeueStack = new Stack<>();
    }

    //adding an item to the queue is O(1) operation
    public void enqueue(int item){
        this.enqueueStack.push(item);
    }

    public int dequeue(){
        //no items in the stack
        if(enqueueStack.isEmpty() && dequeueStack.isEmpty()){
            throw new RuntimeException("Stacks are empty");
        }

        //if the dequeueStack is empty we have to add items O(N) time
        if(dequeueStack.isEmpty()){
            while(!enqueueStack.isEmpty()){
                dequeueStack.push(enqueueStack.pop());
            }
        }
        //otherwise we just have to pop off an item in O(1)
        return dequeueStack.pop();
    }

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();
        myQueue.enqueue(10);
        myQueue.enqueue(5);
        myQueue.enqueue(20);

        System.out.println(myQueue.dequeue());
        System.out.println("-----------------");
        myQueue.enqueue(100);
        System.out.println("-----------------");
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
    }
}
