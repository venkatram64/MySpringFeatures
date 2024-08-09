package com.venkat.alog.dll.que;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ArrayDequeApp {
     public static void myStackWithDeque(){
         Deque<Integer> stack = new ArrayDeque<>();
         long start = System.currentTimeMillis();
         for(int i = 0; i < 5_00_000; i++){
             stack.push(i);
         }
         while(!stack.isEmpty()){
             stack.pop();
         }
         long end = System.currentTimeMillis();
         System.out.println("Time taken with ArrayDeque: " + (end - start) + "ms" );
     }

    public static void myStack(){
        Stack<Integer> stack = new Stack<>();
        long start = System.currentTimeMillis();
        for(int i = 0; i < 5_00_000; i++){
            stack.push(i);
        }
        while(!stack.isEmpty()){
            stack.pop();
        }
        long end = System.currentTimeMillis();
        System.out.println("Time taken with Stack: " + (end - start) + "ms" );
    }

    public static void main(String[] args) {
        myStackWithDeque();
        myStack();
    }
}
