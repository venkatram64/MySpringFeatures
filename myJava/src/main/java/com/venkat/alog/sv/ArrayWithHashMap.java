package com.venkat.alog.sv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
return the best average grade from given input
 */
public class ArrayWithHashMap {
    public static void main(String[] args){
        String[][] scores = {
                {"Charles", "63"},
                {"Bob","85"},
                {"Mark","100"},
                {"Mark","34"}
        };
        System.out.println(bestAverageCalculator(scores));

    }
    public static int bestAverageCalculator(String[][] scores){
        Map<String, List<Integer>> scoreMap = new HashMap<>();

        for(String[] score : scores){
            String name = score[0];
            int currentScore = Integer.parseInt(score[1]);

            if(scoreMap.containsKey(name)){
                List<Integer> scoreList = scoreMap.get(name);
                scoreList.add(currentScore);
                scoreMap.put(name, scoreList);
            }
            else{
                List<Integer> scoreList = new ArrayList<>();
                scoreList.add(currentScore);
                scoreMap.put(name, scoreList);
            }
        }
        int bestAverage = 0;
        for(List<Integer> values : scoreMap.values()){
            int sum = 0;
            for(int score : values){
                sum += score;
            }
            int count = values.size();
            int average = (int)Math.floor(sum/count);
            if(average > bestAverage){
                bestAverage = average;
            }
        }
        return bestAverage;
    }
}
