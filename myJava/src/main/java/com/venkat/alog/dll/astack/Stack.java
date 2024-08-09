package com.venkat.alog.dll.astack;

public class Stack<T> {

    private T[] stack;
    private int count;

    public Stack(){
        stack = (T[]) new Object[1];
    }

    public void push(T newData){
        if(count == stack.length){
            resize(2 * count);
        }
        stack[count++] = newData;
    }

    private void resize(int newCapacity){
        T[] newStack = (T[]) new Object[newCapacity];
        for(int i = 0; i < count; i++){
            newStack[i] = stack[i];
        }
        stack = newStack;
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public T pop(){
        if(isEmpty()){
            return null;
        }
        T item = stack[--count];
        stack[count] = null;
        if(count == stack.length/4){
            resize(stack.length/2);
        }
        return item;
    }
}
