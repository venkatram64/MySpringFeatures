package com.venkat.alog.sv;
/*
Welcome to JDoodle!

You can execute code here in 88 languages. Right now you’re in the Java IDE.

  1. Click the orange Execute button ▶ to execute the sample code below and see how it works.

  2. Want help writing or debugging code? Type a query into JDroid on the right hand side ---------------->

  3.Try the menu buttons on the left. Save your file, share code with friends and open saved projects.

Want to change languages? Try the search bar up the top.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyClass {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :");
        int n = sc.nextInt();
        System.out.println(generate(n));
        //1
        //1 1
        //1 2 1
        //1 3 3 1
        System.out.println("Enter row and column numbers :");
        int row = sc.nextInt();
        int col = sc.nextInt();
        System.out.println("Element is " + getElement(generate(n), row, col));
    }
    public static List<List<Integer>> generate(int n){
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);
        for(int i = 1; i < n; i++){
            List<Integer> prevRow =  triangle.get(i-1);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j = 1; j < i; j++){
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
    public static int getElement(List<List<Integer>> triangle, int row, int col){
        return triangle.get(row).get(col);
    }
}