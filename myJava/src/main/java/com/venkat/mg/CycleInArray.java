package com.venkat.mg;

public class CycleInArray {

    public static int coutLengthOfCycle(int[] arr, int startIndex){
        int slow = startIndex;
        int fast = startIndex;

        //First phase: finding the cycle using Floyd's Tortoise and Hare algorithm
        do{
            if(arr[fast] == -1 || arr[arr[fast]] == -1){
                return -1;//no cycles found
            }
            slow = arr[slow];
            fast = arr[arr[fast]]; //this is two jumps
        }while(slow != fast);

        //Second phase: Finding the start of the cycle
        int cycleStart = startIndex;
        while(cycleStart != slow){
            cycleStart = arr[cycleStart];
            slow = arr[slow];
        }

        System.out.println("Cycle is started at " + slow);

        //Third phase: Finding the length of the cycle
        int cycleLength = 1;
        int current = arr[cycleStart];
        while(current != cycleStart){
            cycleLength++;
            current = arr[current];
        }
        return cycleLength;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,0};
        int startIndex1 = 1;
        int cycleLength1 = coutLengthOfCycle(arr1, startIndex1);
        System.out.println("Cycle length: " + cycleLength1);

        int[] arr2 = {1,2,0};
        int startIndex2 = 0;
        int cycleLength2 = coutLengthOfCycle(arr2, startIndex2);
        System.out.println("Cycle length: " + cycleLength2);
    }
}
