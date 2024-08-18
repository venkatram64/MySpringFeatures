package com.venkat.alog.sv;

public class TwoDArrayWIthoutHashMap {
    public static void main(String[] args){
        String[][] scores = {
                {"Charles", "63"},
                {"Bob", "85"},
                {"Mark", "100"},
                {"Mark", "34"}
        };
        System.out.println(bestAvgCal(scores));

    }
    public static int bestAvgCal(String[][] scores){
        int[] sums = new int[scores.length];
        int[] counts = new int[scores.length];

        int index = 0;
        for(String[] score : scores){
            String name = score[0];
            int currentScore = Integer.parseInt(score[1]);
            boolean found = false;
            for(int i = 0; i < index; i++){
                if(scores[i][0].equals(name)){
                    sums[i] += currentScore;
                    counts[i] += 1;
                    found = true;
                    break;
                }
            }
            if(!found){
                sums[index] = currentScore;
                counts[index]++;
                index++;
            }
        }
        int bestAvg = 0;
        for(int i = 0; i < index; i++){
            int avg = sums[i] / counts[i];
            if(avg > bestAvg){
                bestAvg = avg;
            }
        }
        return bestAvg;
    }
}
