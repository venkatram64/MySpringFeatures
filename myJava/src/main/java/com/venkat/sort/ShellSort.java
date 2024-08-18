package com.venkat.sort;
/*
Shell Sort is the generalization of the insertion sort
 */
public class ShellSort {

    private int[] nums;
    public ShellSort(int[] nums){
        this.nums = nums;
    }
    private void print(String msg){
        System.out.println(msg);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
    //shell sort is an insertion sort variant
    public void sort(){
        for(int gap = nums.length/2; gap > 0; gap/=2){
            for(int i = gap; i < nums.length; ++i){
                int j = i;
                //swaps
                while(j >= gap && nums[j - gap] > nums[j]){
                    swap(j, j - gap);
                    j-=gap;
                }
            }
        }
    }

    private void swap(int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {12, 4, -2, 11, 1, 65, -5, 17, 31, 10, 43, 2, 56, 29, 1};
        //int[] nums = {5, 2, 8, 10, 1, 0, 11};
        ShellSort ss = new ShellSort(nums);
        ss.print("\n Before sorting ");
        ss.sort();
        ss.print("\n After sorting ");
    }
}
