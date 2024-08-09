package com.venkat.alog.sll;

public interface List<T> {

    public void insert(T data);
    public void remove(T data);
    public void traverse();
    public Node get(int index);
    public void reverse();
    public int size();
}
