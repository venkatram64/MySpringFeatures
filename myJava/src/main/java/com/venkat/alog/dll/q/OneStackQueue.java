package com.venkat.alog.dll.q;

import java.util.Stack;

/*
The problem is that we want to implement queue abstract data type with
the enqueue() and dequeue() operations with stacks
we can use 2 stacks to solve this problem
one stack: for enqueue() operation
one stack: for dequeue() operation
 */
public class OneStackQueue {

    //use one stack for enqueue operation
    private Stack<Integer> stack;

    public OneStackQueue(){
        this.stack = new Stack<>();
    }

    public void enqueue(int item){
        this.stack.push(item);
    }

    //use 2 stack again but instead of explicitly define the second stack
    //we use the call-stack of program(stack memory or execution operation)
    public int dequeue(){
        //base case for the recursive method calls the first item
        //is what we are after this is what we need for queue's dequeue operation
        if(stack.size() == 1){
            return stack.pop();
        }

        //we keep popping the items until we find the last one
        int item = stack.pop();

        //we call the method recursively
        int lastDequeuedItem = dequeue();
        //after we find the item we dequeue we have to reinsert the items one by one
        enqueue(item);
        //this the item we are looking for when stack.size() == 1
        return lastDequeuedItem;
    }

    public static void main(String[] args) {
        OneStackQueue myQueue = new OneStackQueue();
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
