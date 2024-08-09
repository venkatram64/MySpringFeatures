package com.venkat.alog.sll;

public class LLApp {

    public static void main(String[] args) {

        /*LinkedList<String> ll = new LinkedList<>();
        ll.insert("Mike");
        ll.insert("John");
        ll.insert("Dave");
        ll.insert("Joy");

        ll.traverse();
        System.out.println();
        ll.remove("John");
        ll.traverse();*/

        LinkedList<Person> ll = new LinkedList<>();
        ll.insert(new Person(60, "Mike"));
        ll.insert(new Person(20, "John"));
        ll.insert(new Person(24, "Dave"));
        ll.insert(new Person(10, "Joy"));
        ll.insert(new Person(14, "Dan"));

        ll.traverse();
        System.out.println();

        Node<Person> m = ll.getMiddleNode();
        System.out.println(m);
        System.out.println();

        ll.remove(new Person(24, "Dave"));
        ll.traverse();
        System.out.println();
        ll.reverse();
        ll.traverse();
    }
}
