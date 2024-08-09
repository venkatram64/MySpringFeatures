package com.venkat.basic;

public class Palindrome {

    public static boolean isPalindrome(String s){
        int farward = 0;
        int backward = s.length() - 1;
        while(farward < backward){
            if(s.toLowerCase().charAt(farward) != s.charAt(backward)){
                return false;
            }
            farward++;
            backward--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "Madam";
        System.out.println(s + " is palindrome " + isPalindrome(s));
    }
}
