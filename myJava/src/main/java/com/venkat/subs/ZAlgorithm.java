package com.venkat.subs;
//O(N+M) linear memory complexity
public class ZAlgorithm {

    private String text;
    private String pattern;
    private int[] zTable;

    public ZAlgorithm(String text, String pattern){
        this.text = text;
        this.pattern = pattern;
        //O(N+M) linear memory complexity
        this.zTable = new int[text.length() + pattern.length()];
    }
    //it has linear O(N + M)
    public void search(){
        constructTable();
        for(int i = 0; i < zTable.length; ++i){
            if(zTable[i] >= pattern.length()){
                System.out.println("Match found at index " + (i - pattern.length()));
            }
        }
    }
    //linear running time is O(N+M)
    private void constructTable(){

        String patternText = pattern + text;
        int n = patternText.length();
        //left pointer
        int left = 0;
        //right pointer
        int right = 0;

        //considering the letters of the S' -> (pattern + text) one by one
        for(int k = 1; k < n; ++k){
            //we have to use the naive z calculation(CASE I)
            if(k > right){
                int matchCounter = 0;
                while(k + matchCounter < n && patternText.charAt(matchCounter) == patternText.charAt(k + matchCounter)){
                    matchCounter++;
                }
                zTable[k] = matchCounter;
                //update left and right indexes
                //we just update the z box indexes if the matchCounter is greater than 0
                if(matchCounter > 0){
                    left = k;
                    right = k + matchCounter - 1;
                }
            }else{
                //k is within a Z box (pair index in the prefix)
                int p = k - left;
                //case II, we can copy the value ( no need to re calculate it again)
                if(zTable[p] < right - k + 1){
                    zTable[k] = zTable[p];
                }else{
                    //but to use naive approach
                    //this is the first item we have to consider outside the z box
                    int i = right + 1;
                    while(i < n && patternText.charAt(i) == patternText.charAt(i - k)){
                        i++;
                    }
                    zTable[k] = i - k;
                    //we have found another Z box
                    left = k;
                    right = i - 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        ZAlgorithm za = new ZAlgorithm("ramvenkatramlaxmanrambarathram", "ram");
        za.search();
    }

}
