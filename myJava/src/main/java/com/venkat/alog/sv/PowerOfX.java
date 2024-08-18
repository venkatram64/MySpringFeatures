package com.venkat.alog.sv;

public class PowerOfX {
    public static double myPow(double x, int n) {
        double multi = 1;
        long nTemp = n;
        if(n < 0){
            nTemp = nTemp * -1;
        }
        for(int i = 1; i <= nTemp; i++){
            multi= multi*x;
        }

        if(n < 0){
            return 1/multi;
        }
        // multi = 1;
        //multi = 2
        return multi;
    }

    public static void main(String[] args) {
        //System.out.println(myPow(0.00001, 2147483647));
        System.out.println(myPow(2,3));
    }
}
