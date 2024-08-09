package com.venkat.basic;

public class Reversing {

    public static int reverse(int num){
        int reversedNum = 0;
        while(num > 0){
            int remainder = num % 10;
            reversedNum = reversedNum * 10 + remainder;
            num = num/10;
        }
        return reversedNum;
    }

    public static void main(String[] args) {
        int num = 1234;
        System.out.println(reverse(num));
    }
}
