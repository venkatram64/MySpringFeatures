package com.venkat.mg;
/*
please write a program for Given a string find the start index and count of character repeating maximum times
 */
public class MaxRepeatingCharacter {

    public static Result findMaxRepeatingChar(String s){
        //handle the empty string case
        if(s == null || s.length() == 0){
            return null;
        }
        char maxChar = s.charAt(0);
        int maxCount = 1;
        char currentChar = s.charAt(0);
        int currentCount = 1;
        int startIndex = 0;
        int maxStartIndex = 0;

        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == currentChar) {
                currentCount++;
            }else{
                if(currentCount > maxCount){
                    maxCount = currentCount;
                    maxChar = currentChar;
                    maxStartIndex = startIndex;
                }
                currentChar = s.charAt(i);
                currentCount = 1;
                startIndex = i;
            }
        }
        //final check for the last sequence in the string
        if(currentCount > maxCount){
            maxCount = currentCount;
            maxChar = currentChar;
            maxStartIndex = startIndex;
        }
        return new Result(maxChar, maxStartIndex, maxCount);
    }
    static class Result {
        char ch;
        int startIndex;
        int count;

        Result(char ch, int startIndex, int count){
            this.ch = ch;
            this.startIndex = startIndex;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        String s = "aabbdddddeeeecc";
        Result result = findMaxRepeatingChar(s);
        if(result != null){
            System.out.println("Charactor is "+result.ch);
            System.out.println("Start index: " + result.startIndex + ", Count: " + result.count);
        }else{
            System.out.println("The String is empty");
        }
    }
}
