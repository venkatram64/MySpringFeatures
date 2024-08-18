package com.venkat.alog.sv;

public class PowOfX {
    public static double myPow(double x, int n){
        double ans = 1.0;
        long nTemp = n;
        if(n < 0){
            nTemp = nTemp * -1;
        }
        while(nTemp > 0){
            if(nTemp % 2 == 0){
                x = x*x;
                nTemp = nTemp/2;
            }else{
                ans = ans * x;
                nTemp--;
            }
        }
        if( n < 0){
            return 1/ans;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(myPow(9.74, 7));
    }
}
