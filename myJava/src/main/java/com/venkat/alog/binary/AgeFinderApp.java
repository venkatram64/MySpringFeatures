package com.venkat.alog.binary;

public class AgeFinderApp {
    public static void main(String[] args) {
        Tree<Person> bst = new BinarySearchTree<>();

        bst.insert(new Person(47,"Adam"));
        bst.insert(new Person(21, "Kevin"));
        bst.insert(new Person(55, "Joe"));
        bst.insert(new Person(20, "Arnold"));
        bst.insert(new Person(34, "Noel"));
        bst.insert(new Person(68, "Marko"));
        bst.insert(new Person(23, "Susan"));
        bst.insert(new Person(38, "Rose"));

        System.out.println("Total Ages " + bst.getTotalAge(bst.getRoot()));
    }
}
