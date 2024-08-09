package com.venkat.alog.dll;

public class DLLApp {

    public static void main(String[] args) {
        DoublyLinkedList<String> dll = new DoublyLinkedList<>();
        dll.insert("Mike");
        dll.insert("Dave");
        dll.insert("Joy");
        dll.insert("John");
        dll.traverseForward();
        System.out.println();
        dll.traverseBackward();
    }
}
