package com.venkat.alog.sv;

public class StringToInteger2 {
    public static int atoi(String str){
        int i = 0;
        int n = str.length();
        int sign = 1;
        int result = 0;
        /*while(i < n && str.charAt(i) == ' '){
            i++;
        }*/
        if(/*i < n &&*/ (str.charAt(i) == '+' || str.charAt(i) == '-')){
            sign = (str.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        while(i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            int digit = str.charAt(i) - '0';
            if(result > (Integer.MAX_VALUE - digit) / 10){
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return result * sign;
    }
    public static void main(String[] args){
        System.out.println(atoi("4fs2"));
        System.out.println(atoi("-42"));
        System.out.println(atoi("2342 with words"));
        System.out.println(atoi("words and 2342"));
        System.out.println(atoi("-91283472332"));
        System.out.println(atoi("-91283472332"));
        System.out.println(atoi("   42"));
    }
}
