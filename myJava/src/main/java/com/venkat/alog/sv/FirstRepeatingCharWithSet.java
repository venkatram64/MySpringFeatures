package com.venkat.alog.sv;



import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingCharWithSet {

    public static Character findFirstRepeatingChar(String str){
        Set<Character> seen = new HashSet<>();
        for(char c : str.toCharArray()){
            if(seen.contains(c)){
                return c;
            }
            seen.add(c);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("First repeating character in 'apple': "+ findFirstRepeatingChar("apple"));
        System.out.println("First repeating character in 'racecar': "+ findFirstRepeatingChar("racecar"));
        System.out.println("First repeating character in 'xyzzyg': "+ findFirstRepeatingChar("xyzzyg"));
    }
}
