package com.venkat.basic;

public class ReverseNumber {

    //no need extra memory in-place algorithm
    //O(N/2) = O(N) linear running time
    public static void reverse(int[] nums){
        int lowIndex = 0;
        int highIndex = nums.length - 1;
        while(lowIndex < highIndex){
            swap(nums, lowIndex, highIndex);
            lowIndex++;
            highIndex--;
        }
    }

    public static void swap(int[] nums, int lowIndex, int highIndex){
        int temp = nums[lowIndex];
        nums[lowIndex] = nums[highIndex];
        nums[highIndex] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        for(Integer i : nums){
            System.out.print(i + "  ");
        }
        reverse(nums);
        System.out.println();
        for(Integer i : nums){
            System.out.print(i + "  ");
        }
    }
}
