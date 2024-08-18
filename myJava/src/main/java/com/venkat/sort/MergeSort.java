package com.venkat.sort;

/*
developed by John Neumann
running time complexity is O(NlogN)
space complexity O(N)
 */

public class MergeSort {

    private int[] nums;
    //it is not in-place algorithm
    private int[] tempArray;

    public MergeSort(int[] nums){
        this.nums = nums;
        this.tempArray = new int[nums.length];
    }

    public void sort(){
        mergeSort(0, nums.length - 1);
    }

    private void mergeSort(int low, int high) {
        //base case
        if(low >= high){
            return;
        }
        //middle item
        int middleIndex = (low + high)/2;
        //keep splitting the problem into smaller problems recursively
        //until sub-array contains 1 element
        mergeSort(low, middleIndex); //left sub-array
        mergeSort(middleIndex + 1, high);//right sub-array
        //then combine the sub-solutions
        merge(low, middleIndex, high);
    }

    private void merge(int low, int middleIndex, int high){
        //copy the elements into tempArray
        for(int i = low; i <= high; i++){
            tempArray[i] = nums[i];
        }
        int i = low;//left sub-array
        int j = middleIndex + 1;//right sub-array
        int k = low;//temp array
        //temp array elements should be copied into original nums array
        while(i <= middleIndex && j <= high){
            if(tempArray[i] < tempArray[j]){
                nums[k] = tempArray[i];
                ++i;
            }else{
                nums[k] = tempArray[j];
                ++j;
            }
            ++k;
        }
        //copy the items from left sub-array if there are any left over
        while(i <= middleIndex){
            nums[k] = tempArray[i];
            ++k;
            ++i;
        }
        //copy the items from right sub-array if there are any left over
        while(j <= high){
            nums[k] = tempArray[j];
            ++k;
            ++j;
        }

    }

    private void print(String msg){
        System.out.println(msg);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {12, 4, -2, 11, 1, 65, -5, 17, 31, 10, 43, 2, 56, 29, 1};
        MergeSort qs = new MergeSort(nums);
        qs.print("\n Before sorting");
        qs.sort();
        qs.print("\n After sorting");
    }
}
