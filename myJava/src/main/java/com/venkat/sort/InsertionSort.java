package com.venkat.sort;

public class InsertionSort {

    private int[] nums;
    public InsertionSort(int[] nums){
        this.nums = nums;
    }

    private void print(String msg){
        System.out.println(msg);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }

    public void sort(){
        for(int i = 0; i < nums.length; ++i){
            int j = i;
            //swaps
            while(j > 0 && nums[j - 1] > nums[j]){
                swap(j, j-1);
                j--;
            }
        }
    }

    private void swap(int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 8, 10, 1, 0, 11};
        InsertionSort is = new InsertionSort(nums);
        is.print("Before sorting");
        is.sort();
        is.print("\n After sorting");

    }

}
