package com.venkat.alog.sv;

public class GFG {
    public static void main(String[] args) {
        String[][] scores = {
                {"Charles", "63"},
                {"Bob", "85"},
                {"Mark", "100"},
                {"Mark", "34"}
        };
        System.out.println(bestAvgCal(scores));
    }

    public static int bestAvgCal(String[][] scores) {
        // Step 1: Determine unique names and their respective scores
        int[] sums = new int[scores.length]; // To store sum of scores for each student
        int[] counts = new int[scores.length]; // To store count of scores for each student

        // Step 2: Iterate through scores to calculate sums and counts
        int index = 0;
        for (String[] score : scores) {
            String name = score[0];
            int currentScore = Integer.parseInt(score[1]);

            // Find if name already exists
            boolean found = false;
            for (int i = 0; i < index; i++) {
                if (scores[i][0].equals(name)) {
                    sums[i] += currentScore;
                    counts[i]++;
                    found = true;
                    break;
                }
            }

            // If name doesn't exist, add it to arrays
            if (!found) {
                sums[index] = currentScore;
                counts[index] = 1;
                index++;
            }
        }

        // Step 3: Calculate best average
        int bestAvg = 0;
        for (int i = 0; i < index; i++) {
            int avg = sums[i] / counts[i]; // Calculate average for each student
            if (avg > bestAvg) {
                bestAvg = avg;
            }
        }

        return bestAvg;
    }
}

