package com.venkat.sort;
//Algorithm maintains the order of items with equal keys is the stable sort
public class BogoSort {

    //O(N!), not for classical computers, it is for Quantum
    private int[] nums;
    private int counter;

    public BogoSort(int[] nums){
        this.nums = nums;
    }

    public void sort(){
        while(!isSorted()){
            counter++;
            shuffle();
        }
        showSortedArray();
    }

    private void showSortedArray(){
        System.out.println("The number of iterations: " + counter);
        for(int i = 0; i < nums.length; ++i){
            System.out.print(nums[i] + "  ");
        }
    }

    private boolean isSorted(){
        //ascending
        for(int i = 0; i < nums.length - 1; ++i){
            if(nums[i+1] < nums[i]){
                return false;
            }
        }
        return true;
    }
    //Fisher-Yates algorithm to generate a random permutation in O(N)
    //in-place algorithm
    private void shuffle(){
        for(int i = nums.length - 1; i >= 0; --i){
            int j = (int) (Math.random() * i);//getting the index as random
            swap(i, j);
        }
    }
    private void swap(int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {5, 2, 8, 10, 1, 0, 11};
        BogoSort bogoSort = new BogoSort(nums);
        bogoSort.sort();
    }
}
