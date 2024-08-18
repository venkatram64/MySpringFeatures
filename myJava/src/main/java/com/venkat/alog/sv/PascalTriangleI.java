package com.venkat.alog.sv;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangleI {
    public static List<List<Integer>> generate (int rowIndex){
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);
        for(int i = 1; i <= rowIndex; i++){
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(i-1);
            row.add(1);
            for(int j = 1; j < i; j++){
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }

    public static void printTriangle(List<List<Integer>> triangle) {
        for (List<Integer> row : triangle) {
            for (Integer num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = generate(rowIndex);
        //print the triangle
        printTriangle(triangle);
        return triangle.get(rowIndex);
    }
    public static void main(String[] args) {
        //1
        //1 1
        //1 2 1
        //1 3 3 1
        //1 4 6 4 1
        //1 5 10 10 5 1
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter : ");
        int n = sc.nextInt();
        System.out.println(getRow(n));

    }
}
