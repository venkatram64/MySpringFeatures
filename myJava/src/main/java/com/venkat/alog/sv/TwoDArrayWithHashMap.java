package com.venkat.alog.sv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoDArrayWithHashMap {
    public static void main(String[] args) {
        String[][] scores = {
                {"Charles", "63"},
                {"Bob","85"},
                {"Mark","100"},
                {"Mark","34"}
        };
        System.out.println(bestAvgCal(scores));

    }
    public static int bestAvgCal(String[][] scores){
        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        for( String []score: scores){
            String name = score[0];
            String currentScore = score[1];

            if(map.containsKey(name)){
                List<Integer> list = map.get(name);
                list.add(Integer.parseInt(currentScore)); //[100,34]
                map.put(name, list);
            }
            else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(Integer.parseInt(currentScore));
                map.put(name, list);
            }

        }

        //63
        //85
        //100,34
        int bestAvg = 0;
        for(List<Integer> value : map.values()){
            int sum = 0;
            for(Integer i : value){
                sum += i;
            }
            int count = value.size();
            int avg = sum/count;
            if(bestAvg < avg){
                bestAvg = avg;
            }
        }
        return bestAvg;
    }

}
