package com.venkat.alog.sv;

public class PowerOfTwoAndTen {
    public static boolean isPowerOfTwo(int n) {
        boolean val = true;
        if(n == 0){
            return false;
        }
        /*else if(n == 1){
            return true;
        }*/
        /*while(n != 1){
            if(n % 2 != 0){
                val = false;
                break;
            }
            else{
                val = true;
            }
            n = n/2;
        }*/
        while(n > 1){
            if(n % 10 != 0){
                val = false;
                break;
            }
            n = n / 10;
        }
        return val;
    }
    public static void main(String[] args) {
        System.out.println( isPowerOfTwo(1000));
    }
}
/*
*
*
* */