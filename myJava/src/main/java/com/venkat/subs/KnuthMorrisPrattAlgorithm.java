package com.venkat.subs;

public class KnuthMorrisPrattAlgorithm {

    private String text;
    private String pattern;
    private int[] pi;

    public KnuthMorrisPrattAlgorithm(String text, String pattern){
        this.text = text;
        this.pattern = pattern;
        this.pi = new int[text.length()];
    }

    //pre-compute the partial match table in O(M) running time
    public void constructPITable(){
        int prefixCounter = 0;
        int i = 1;
        while(i < pattern.length()){
            if(text.charAt(i) == pattern.charAt(prefixCounter)){
                prefixCounter++;
                pi[i] = prefixCounter;
                i++;
            }else{
                if(prefixCounter != 0){
                    prefixCounter = pi[prefixCounter - 1];
                }else{
                    pi[i] = 0;
                    i++;
                }
            }
        }
    }

    public void search(){
        constructPITable();
        //i tracks the letters in the text - j ttracks the letters in the pattern
        int i = 0;
        int j = 0;
        while(i < text.length() && j < pattern.length()){
            //if the letters match, increment the indexes
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }
            //we have found the pattern(re-initialize the index j to be able
            //to find more patterns)
            if(j == pattern.length()){
                System.out.println("Found pattern at index: " + (i -j));
                j = pi[j - 1];
            }
            //in case of mismatch (the letters are not matching)
            if(i < text.length() && text.charAt(i) != pattern.charAt(j)){
                //if j is not 0 then we can use the partial match table
                if(j != 0){
                    j = pi[j - 1];
                }else{
                    //if the j = 0 then we have no other option but to increment u
                    i++;
                }
            }
        }
    }
    public static void main(String[] args) {
        KnuthMorrisPrattAlgorithm za = new KnuthMorrisPrattAlgorithm("ramvenkatramlaxmanrambarathram", "ram");
        za.search();
    }
}
