package com.venkat.subs;
/*
Rabin fingerprint equation
f(x) = m0 + m1x +....+ m(n-1)x^n-1
average case running time complexity O(M+N)
worst time case is O(MN)
 */
public class RabinKarp {
    //size of the alphabets
    private int d = 26;
    //prime number
    private int q = 31;

    public int search(String text, String pattern){
        int patternLength = pattern.length();
        int textLength = text.length();

        //hash for the region of text and pattern
        int hashText = 0;
        int hashPattern = 0;

        //largest polynomial term in the fingerprint function
        int h = 1;
        //largest polynomial term
        for(int i = 0; i < patternLength - 1; ++i){
            h = (h * d) % q;
        }
        //pre-compute the hash of the pattern O(M)
        for(int i = 0; i < patternLength; ++i){
            hashPattern = (d * hashPattern + pattern.charAt(i)) % q;
            hashText = (d * hashText + text.charAt(i)) % q;
        }

        //slide the pattern over text one by one
        for(int i = 0; i <= textLength - patternLength; ++i){
            //check the hash values of current window of text
            //and pattern.  If the hash values match then only
            //check for characters one by one
            if(hashPattern == hashText){
                int j = 0;
                //if the hash matches then we have to check the letters one by one
                for(j = 0; j < patternLength; ++j){
                    if(text.charAt(i + j) != pattern.charAt(j)){
                        break;
                    }
                }
                //all the characters are matching it is a match
                if(j == patternLength){
                    return i;
                }
            }
            //update the hash for the actual substring of the text(venkatram)
            //rolling hashing -> h(ven) = h(ven) - h(v) + h(k)
            if(i < textLength - patternLength){
                hashText = ((hashText - text.charAt(i) * h) * d + text.charAt(i + patternLength)) % q;
                //we may get -ve values
                if(hashText < 0){
                    hashText += q;
                }
            }
        }
        //search miss
        return -1;
    }

    public static void main(String[] args) {
        RabinKarp rk = new RabinKarp();
        System.out.println(rk.search("Venkatram", "ram"));
    }
}
