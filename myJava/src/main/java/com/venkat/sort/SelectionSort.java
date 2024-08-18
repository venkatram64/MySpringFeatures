package com.venkat.sort;

public class SelectionSort {
    private int[] nums;

    public SelectionSort(int[] nums){
        this.nums = nums;
    }

    private void print(String msg){
        System.out.println(msg);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }

    public void ascendingSort(){
        for(int i = 0; i < nums.length - 1; ++i){
            int index = i;
            //get min value
            for(int j = i + 1; j < nums.length; ++j){
                if(nums[j] < nums[index]){
                    index = j;
                }
            }
            if(index != i) {
                swap(i, index);
            }
        }
    }

    public void descendingSort(){
        for(int i = 0; i < nums.length - 1; ++i){
            int index = i;
            //get max value
            for(int j = i + 1; j < nums.length; ++j){
                if(nums[j] > nums[index]){
                    index = j;
                }
            }
            if(index != i) {
                swap(i, index);
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
        SelectionSort ss = new SelectionSort(nums);
        ss.print("Before sorting");
        ss.ascendingSort();
        ss.print("\n After sorting");

        ss.descendingSort();
        ss.print("\n After sorting");
    }
}
