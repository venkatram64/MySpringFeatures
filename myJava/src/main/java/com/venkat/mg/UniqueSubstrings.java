package com.venkat.mg;

import java.util.HashSet;
import java.util.Set;

public class UniqueSubstrings {

    public static void main(String[] args) {
        String input = "aab";
        Set<String> uniqueSubstrings = findUniqueSubstrings(input);
        System.out.println("Unique substrings of '" + input + "': " + uniqueSubstrings);
    }

    public static Set<String> findUniqueSubstrings(String str){
        Set<String> uniqueSubstrings = new HashSet<>();

        for(int i = 0; i < str.length(); i++){
            for(int j = i + 1; j <= str.length(); j++){
                String substring = str.substring(i, j);
                uniqueSubstrings.add(substring);
            }
        }
        return uniqueSubstrings;
    }
}
