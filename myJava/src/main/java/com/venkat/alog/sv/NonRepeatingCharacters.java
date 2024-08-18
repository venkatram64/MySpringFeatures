package com.venkat.alog.sv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NonRepeatingCharacters {
    public static void main(String[] args) {
        String[] array = {"", "racecar","xyzzyg"};
        for(String s : array){
            List<Character> nonRepeated = findNonRepeatingCharacters(s);
            System.out.println(nonRepeated + "-> " + s);
        }

    }
    public static List<Character> findNonRepeatingCharacters(String str) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for(char c : str.toCharArray()){
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        List<Character> nonRepatingCharacters = new ArrayList<>();
        for(char c : str.toCharArray()){
            if(charCountMap.get(c) ==  1){
                nonRepatingCharacters.add(c);
                break;
            }
        }
        return nonRepatingCharacters;
    }
}


