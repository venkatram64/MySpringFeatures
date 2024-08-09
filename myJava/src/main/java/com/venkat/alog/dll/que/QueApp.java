package com.venkat.alog.dll.que;

public class QueApp {

    public static void main(String[] args) {
        Queue<String> names = new Queue<>();
        names.enqueue("Mike");
        names.enqueue("Dave");
        names.enqueue("Steve");
        names.enqueue("Ernie");
        System.out.println("Size = " + names.size());
        names.traverse();
        System.out.println();
        System.out.println(names.dequeue());
        System.out.println("Size = " + names.size());
    }
}
