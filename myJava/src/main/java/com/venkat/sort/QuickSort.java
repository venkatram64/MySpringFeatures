package com.venkat.sort;

//quick sort developed by Tony Hoare
//average running time complexity has O(NlogN), worst case running time is O(N^2)

public class QuickSort {

    private int[] nums;

    public QuickSort(int[] nums){
        this.nums = nums;
    }
    private void print(String msg){
        System.out.println(msg);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }

    public void sort(){
        sort(0, nums.length - 1);
    }

    private void sort(int low, int high){
        //base case
        if(high < low){
            return;
        }
        //pivot item is in its sorted position
        int pivot = partition(low, high);
        //method recursively(left and right) array
        sort(low, pivot - 1); //left array
        sort(pivot + 1, high); //right array
    }

    //gives the index of pivot
    private int partition(int low, int high){
        //index of the pivot
        int middleItem = (low + high)/2;
        //swap the pivot with last item
        swap(middleItem, high);
        int i = low;
        for(int j = low; j < high; ++j){
            if(nums[j] <= nums[high]){
                swap(i, j);
                i++;
            }
        }
        //swap back the pivot(middle item)
        swap(i, high);
        return i;
    }

    private void swap(int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {12, 4, -2, 11, 1, 65, -5, 17, 31, 10, 43, 2, 56, 29, 1};
        QuickSort qs = new QuickSort(nums);
        qs.print("\n Before sorting");
        qs.sort();
        qs.print("\n After sorting");
    }
}
