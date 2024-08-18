package com.venkat.mg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Find non repeated characters from string in String array[]
public class NonRepeatingCharacters {

    public static void main(String[] args) {
        String[] array = {"apple", "racecar", "xyzzyg"};
        for (String str : array) {
            List<Character> nonRepeated = findNonRepeatingChars(str);
            System.out.println("Non-repeated characters in '" + str + "': " + nonRepeated);
        }
    }

    public static List<Character> findNonRepeatingChars(String str){
        Map<Character, Integer> charCountMap = new HashMap<>();

        for(char c: str.toCharArray()){
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        List<Character> nonRepeatingChars = new ArrayList<>();
        for(char c: str.toCharArray()){
            if(charCountMap.get(c) == 1){
                nonRepeatingChars.add(c);
            }
        }
        return nonRepeatingChars;
    }
}
