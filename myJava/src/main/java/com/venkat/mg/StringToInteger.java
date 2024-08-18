package com.venkat.mg;
/*
Take a string and return the int value represent by string like atoi("42") return 42,
Use full coding instead of any in built function and correct the existing code.  Space and time complexity of program
 */
public class StringToInteger {

    public static int atoi(String str){
        int i = 0;
        int n = str.length();
        int sign = 1;
        int result = 0;

        //skip leading whitespaces
        while(i < n && str.charAt(i) == ' '){
            i++;
        }
        //check if the next character is a sign
        if(i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')){
            sign = (str.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        //process the numeric characters and build the integer
        while(i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            //int digit2 = str.charAt(i);
            //to get the integer value should be substracted '0'
            int digit = str.charAt(i) - '0';

            //check for overflow/underflow
            if(result > (Integer.MAX_VALUE - digit) / 10){
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }
        return result * sign;
    }

    public static void main(String[] args) {
        System.out.println(atoi("42"));
        System.out.println(atoi("   42"));
        System.out.println(atoi("2342 with words"));
        System.out.println(atoi("words and 2342"));
        System.out.println(atoi("-91283472332"));
        System.out.println(atoi("91283472332"));
    }
}
