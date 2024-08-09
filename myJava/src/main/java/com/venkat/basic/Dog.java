package com.venkat.basic;

public class Dog {
    private static String name;
    public Dog(String name){
        Dog.name = name;
    }

    public void print(){
        System.out.println("Name= " + name);
    }

    public static void main(String[] args) {
        Dog rex = new Dog("Rex");
        Dog fluffy = new Dog("Fluffy");
        rex.print();
        fluffy.print();
    }
}
