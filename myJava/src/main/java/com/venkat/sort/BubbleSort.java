package com.venkat.sort;

public class BubbleSort {

    private int[] nums;
    public BubbleSort(int[] nums){
        this.nums = nums;
    }

    public void show(String msg){
        System.out.println(msg);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }

    public void sort(){
        for(int i = 0; i < nums.length - 1; ++i){
            for(int j = 0; j < nums.length - i - 1; ++j){
                if(nums[j] > nums[j + 1]){
                    swap(j, j+1);
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
        int[] nums = {5, 2, 8, 10, 1, 0, 11};
        BubbleSort bs = new BubbleSort(nums);
        bs.show("Before sorting");
        bs.sort();
        bs.show("\nAfter sorting");
    }

}
