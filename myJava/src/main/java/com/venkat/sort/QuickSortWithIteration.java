package com.venkat.sort;

import java.util.Stack;

public class QuickSortWithIteration {

    private int[] nums;

    public QuickSortWithIteration(int[] nums){
        this.nums = nums;
    }

    public void sort(){
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(nums.length - 1);

        while(!stack.isEmpty()){
            int high = stack.pop();
            int low = stack.pop();

            int pivotIndex = partition(low, high);

            //working with right side
            if(pivotIndex + 1 < high){
                stack.push(pivotIndex + 1);
                stack.push(high);
            }

            //working with left side
            if(pivotIndex - 1 > low){
                stack.push(low);
                stack.push(pivotIndex - 1);
            }
        }
    }

    private int partition(int low, int high){
        int pivotIndex = (low + high) / 2;
        swap(pivotIndex, high);
        int i = low;
        for(int j = low; j < high; ++j){
            if(nums[j] <= nums[high]){
                swap(i, j);
                i++;
            }
        }
        swap(i, high);
        return i;
    }

    private void swap(int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] getNums(){
        return this.nums;
    }

    private void print(String msg){
        System.out.println(msg);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {12, 4, -2, 11, 1, 65, -5, 17, 31, 10, 43, 2, 56, 29, 1};
        QuickSortWithIteration qs = new QuickSortWithIteration(nums);
        qs.print("\n Before sorting");
        qs.sort();
        qs.print("\n After sorting");
    }
}
