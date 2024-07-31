package com.venkat.gneric.extra;


import com.venkat.gneric.extra.model.LPAStudent;
import com.venkat.gneric.extra.model.Student;
import com.venkat.gneric.extra.util.QueryList;

import java.util.ArrayList;
import java.util.List;

public class MyMain {
    public static void main(String[] args) {
        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for(int i = 0; i < studentCount; i++){
            students.add(new Student());
        }
        //students.add(new LPAStudent());
        //printList(students);
        printMoretLists(students);

        List<LPAStudent> lpaStudents = new ArrayList<>();
        for(int i = 0; i < studentCount; i++){
            lpaStudents.add(new LPAStudent());
        }
        //printList(lpaStudents);
        printMoretLists(lpaStudents);
        //who is taking python as course
        var queryList = new QueryList<>(lpaStudents);
        var matches = queryList.getMatches(
                "Course", "Python"
        );
        printMoretLists(matches);

        var students2021 = QueryList.<Student>getMatches(students, "YearStarted", "2021");
        printMoretLists(students2021);
    }

    //A wildcard can only be used in a type argument, not in the type parameter
    //declaration. A wildcard is represented with the ? character
    //A wild card means the type is unknown
    //For this reason, a wildcard limits what you can do, when you specify a type this way.
    public static void printMoretLists2(List<? extends Student> students){
        /*Student last = students.get(students.size() - 1);
        students.set(0, last);*/
        for(var student : students){
            //System.out.println(student);
            System.out.println(student.getYearStarted() + ": " + student);
        }
        System.out.println();
    }

    public static void printMoretLists(List<? super LPAStudent> students){

        for(var student : students){
            System.out.println( student);
        }
        System.out.println();
    }

    //generic method
    /*public static <T extends Student> void printList(List<T> students){
        for(var student : students){
            //System.out.println(student);
            System.out.println(student.getYearStarted() + ": " + student);
        }
        System.out.println();
    }*/
}
