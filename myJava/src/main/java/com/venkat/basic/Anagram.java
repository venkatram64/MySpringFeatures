package com.venkat.basic;

import java.util.Arrays;
import java.util.Comparator;

public class Anagram {

    public static void bubbleSort(char[] c){
        char temp;
        for(int i = 0; i < c.length; i++){
            for(int j = 1; j < c.length - i ; j++){
                if(c[j-1] >= c[j]){
                    temp = c[j-1];
                    c[j-1] = c[j];
                    c[j] = temp;
                }
            }
        }
    }

    public static boolean solve3(char[] s1, char[] s2){
        if(s1.length != s2.length){
            return false;
        }
        bubbleSort(s1);
        bubbleSort(s2);

        for(int i = 0; i < s1.length; i++){
            if(s1[i] != s2[i]){
                return false;
            }
        }
        return true;
    }

    public static Character[] sort(char[] ch){
        //converting char[] to Character object
        Character[] character = new Character[ch.length];
        for(int i = 0; i < ch.length; i++){
            character[i] = ch[i];
        }

        Arrays.sort(character, new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                return Character.compare(Character.toLowerCase(c1), Character.toLowerCase(c2));
            }
        });
        return character;
    }

    public static boolean solve2(char[] s1, char[] s2){
        if(s1.length != s2.length){
            return false;
        }
        Character[] c1 = sort(s1);
        Character[] c2 = sort(s2);

        for(int i = 0; i < s1.length; i++){
            if(c1[i] != c2[i]){
                return false;
            }
        }
        return true;
    }

    public static boolean solve(char[] s1, char[] s2){
        if(s1.length != s2.length){
            return false;
        }
        Arrays.sort(s1);
        Arrays.sort(s2);

        for(int i = 0; i < s1.length; i++){
            if(s1[i] != s2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "Venkat";
        String s2 = "Ram";

        System.out.println("Is it a given string anagram " + solve3(s1.toCharArray(), s2.toCharArray()));
        s1 = "restful";
        s2 = "fluster";
        System.out.println("Is it a given string anagram " + solve3(s1.toCharArray(), s2.toCharArray()));
    }
}
