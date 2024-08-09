package com.venkat.gneric;

import java.util.Arrays;
import java.util.List;

interface Shape{
    void draw();
}

class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Drawing rectangle...");
    }
}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Drawing circle...");
    }
}

public class Shapes {

    public static void print(List<Shape> shapes){
        for(Shape s : shapes){
            s.draw();
        }
    }

    public static <T extends Shape> void print2(List<T> shapes){
        for(Shape s : shapes){
            s.draw();
        }
    }

    /*
    Upper Bounded Wildcards
    1. we can read items from a List<? extends T>
    2. we can not insert(add) items into a List<? extends T>
    we may want to use wildcards with subtypes so child classes
    for example we want to show the items in a List<Rectangle> when the
    Rectangle is a Shape
    below method can accept a list of any subclass of T
     */
    public static  void print3(List<? extends Shape> shapes){
        for(Shape s : shapes){
            s.draw();
        }
    }


    public static void main(String[] args) {
        //List<Shape> shapes = List.of(new Rectangle(), new Circle());
        List<Shape> shapes = Arrays.asList(new Rectangle(), new Circle());
        print(shapes);

        List<Rectangle> myR = Arrays.asList(new Rectangle());
        print2(myR);

        List<Rectangle> myR2 = Arrays.asList(new Rectangle());
        print3(myR);
    }
}
