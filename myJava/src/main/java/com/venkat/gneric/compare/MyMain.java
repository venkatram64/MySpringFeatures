package com.venkat.gneric.compare;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class MyMain {

    public static void main(String[] args) {
        Integer five = 5;
        Integer[] others = {0, 5,10, -50, 50};

        for(Integer i : others){
            int val = five.compareTo(i);
            System.out.printf("%d %s %d: compareTo=%d%n", five, (val == 0 ? "==" : (val < 0) ? "<" : ">"), i, val);
        }

        String banana = "banana";
        String[] fruit = {"apple", "banana", "pear", "BANANA"};

        for(String s : fruit){
            int val = banana.compareTo(s);
            System.out.printf("%s %s %s: compareTo=%d%n", banana,(val == 0 ? "==" : (val < 0) ? "<" : ">"), s, val);
        }

        Arrays.sort(fruit);
        System.out.println(Arrays.toString(fruit));

        System.out.println("A: " + (int)'A' + " " + "a:" +(int)'a');
        System.out.println("B: " + (int)'A' + " " + "b:" +(int)'b');
        System.out.println("P: " + (int)'P' + " " + "p:" +(int)'p');

        Student tim = new Student("Tim");
        Student[] students = {new Student("Zach"), new Student("Tim"), new Student("Ann")};

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

        Student2[] students2= {new Student2("Zach"), new Student2("Tim"), new Student2("Ann")};

        Arrays.sort(students2);
        System.out.println(Arrays.toString(students2));

        //

        /*Comparator<Student2> gpaSorter = new StudentGPAComparator();
        Arrays.sort(students2, gpaSorter);
        System.out.println(Arrays.toString(students2));*/

        Comparator<Student2> gpaSorter = new StudentGPAComparator();
        Arrays.sort(students2, gpaSorter.reversed());
        System.out.println(Arrays.toString(students2));
    }
}

class Student implements Comparable<Student> {
    private String name;
    public Student(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public int compareTo(Student other){
        return name.compareTo(other.name);
    }
}

class StudentGPAComparator implements Comparator<Student2>{
    public int compare(Student2 o1, Student2 o2){
        return (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
        //return (o2.gpa + o2.name).compareTo(o1.gpa + o1.name);
    }
}

class Student2 implements Comparable<Student2> {

    private static int LAST_ID = 1000;
    private static Random random = new Random();

    String name;
    private int id;
    protected double gpa;


    public Student2(String name){
        this.name = name;
        id = LAST_ID++;
        gpa = random.nextDouble(1.0, 4.0);
    }

    @Override
    public String toString(){
        return "%d - %s (%.2f)".formatted(id, name, gpa);
    }

    @Override
    public int compareTo(Student2 other){
        return Integer.valueOf(id).compareTo(Integer.valueOf(other.id));
    }
}
