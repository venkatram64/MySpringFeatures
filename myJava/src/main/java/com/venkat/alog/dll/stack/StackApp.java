package com.venkat.alog.dll.stack;


public class StackApp {

    public static void main(String[] args){
       Stack<String> names = new Stack<>();
       names.push("Mike");
       names.push("Steve");
       names.push("Ernie");
       System.out.println("Size = "+ names.size());
       names.traverse();
       /*System.out.println(items.pop());
       System.out.println("Size = "+ items.size());*/
    }
}
