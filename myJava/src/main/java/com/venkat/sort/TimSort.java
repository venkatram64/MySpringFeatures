package com.venkat.sort;

/*
TimSort is a hybrid sorting algorithm combining merge sort and insertion sort
 */
public class TimSort {
    private int[] nums;
    private int[] tempArray;

    public TimSort(int[] nums){
        this.nums = nums;
        this.tempArray = new int[this.nums.length];
    }

    public void sort(){
        mergeSort(0, nums.length - 1);
    }

    private void mergeSort(int low, int high){
        if(high - low < 5){ //32, 64
            insertionSort(low, high);
            return;
        }
        int middle = (low + high) / 2;
        mergeSort(low, middle);
        mergeSort(middle + 1, high);
        merge(low, middle, high);
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

    private void insertionSort(int low, int high){
        for(int i = low+1; i <= high; ++i){
            int j = i;
            //swaps
            while(j > low && nums[j - 1] > nums[j]){
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

    private void print(String msg){
        System.out.println(msg);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {12, 4, -2, 11, 1, 65, -5, 17, 31, 10, 43, 2, 56, 29, 1};
        TimSort ts = new TimSort(nums);
        ts.print("\n Before sorting");
        ts.sort();
        ts.print("\n After sorting");
    }
}
