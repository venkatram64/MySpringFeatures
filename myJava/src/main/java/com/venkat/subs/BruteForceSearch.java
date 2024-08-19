package com.venkat.subs;
/*
running time complexity O(NM)
 */
public class BruteForceSearch {

    public int search(String text, String pattern){
        int lengthOfText = text.length();
        int lengthOfPattern = pattern.length();

        for(int i = 0; i <= lengthOfText - lengthOfPattern; ++i){
            //this j is tracking the letters of the pattern
            int j;
            //comparing starts with patterns and text
            for(j = 0; j < lengthOfPattern; ++j){
                if(text.charAt(i + j) != pattern.charAt(j)){
                    break;
                }
            }
            //if patterns matches in the text
            if(j == lengthOfPattern){
                return i;
            }
        }
        //mismatch
        return -1;
    }

    public static void main(String[] args) {
        BruteForceSearch bfs = new BruteForceSearch();
        System.out.println(bfs.search("Venkatram", "rama"));
    }
}
