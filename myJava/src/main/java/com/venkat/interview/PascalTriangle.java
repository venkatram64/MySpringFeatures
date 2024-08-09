package com.venkat.interview;

public class PascalTriangle {

    public static void generatePascalTriangle(int numRows) {
        //in java, each row can have different length,
        // for eg triangle.length this gives the number of rows, triangle[0].length gives the number of
        //columns in the first row
        //int[][] triangle = new int[numRows][], first [] -> number of rows, second [] -> number of columns
        int[][] triangle = new int[numRows][];

        for (int i = 0; i < numRows; i++) {
            triangle[i] = new int[i + 1]; //column array in a row arrow
            triangle[i][0] = 1;  // First element of each row is 1
            triangle[i][i] = 1;  // Last element of each row is 1

            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
            }
        }

        // Print the Pascal's Triangle
        for (int i = 0; i < numRows; i++) {
            // Print spaces for formatting
            for (int j = 0; j < numRows - i - 1; j++) {
                System.out.print("   ");
            }

            for (int j = 0; j <= i; j++) {
                //if you want co-ordinate
                System.out.printf("%d(%d,%d)", triangle[i][j], i, j);
                //below is for without coordinates
                //System.out.printf("%4d", triangle[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numRows = 5;
        generatePascalTriangle(numRows);
    }
}
