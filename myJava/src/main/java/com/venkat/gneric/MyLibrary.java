package com.venkat.gneric;

import java.util.ArrayList;
import java.util.List;

interface Algorithm{
    public void execute();
}

class SearchAlgorithm implements Algorithm{

    @Override
    public void execute() {
        System.out.println("SearchAlgorithm");
    }
}

class SortAlgorithm implements Algorithm{

    @Override
    public void execute() {
        System.out.println("SortAlgorithm");
    }
}

class GraphAlgorithm implements Algorithm{

    @Override
    public void execute() {
        System.out.println("GraphAlgorithm");
    }
}

class Library<T extends Algorithm> {

    List<T> algorithms;
    public Library(){
        algorithms = new ArrayList<>();
    }

    public void add(T algorithm){
        algorithms.add(algorithm);
    }

    public T getLast(){
        if(algorithms.size() == 0){
            return null;
        }
        T actualItem = algorithms.remove(algorithms.size() - 1);
        return actualItem;
    }
}

public class MyLibrary {

    public static void main(String[] args) {

        Library<Algorithm> library = new Library<>();
        library.add(new SearchAlgorithm());
        library.add(new SortAlgorithm());
        library.add(new GraphAlgorithm());
        Algorithm item = library.getLast();
        while(item != null){
            item.execute();
            item = library.getLast();
        }
    }
}
