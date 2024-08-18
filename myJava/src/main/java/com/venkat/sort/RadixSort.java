package com.venkat.sort;

import java.util.Arrays;

public class RadixSort {
    //for radix sort Least Specific Digit(LSD) considering single digits for cumulative array
    private static final int ITEMS = 10;
    private int[] data;

    public RadixSort(int[] data){
        this.data = data;
    }

    private void print(String msg){
        System.out.println(msg);
        for(int i = 0; i < data.length; i++){
            System.out.print(data[i] + " ");
        }
    }

    public void sort(){
        //make as many iterations as the number of digits
        //in the largest item of the dataset
        int place = 1;
        for(int i = 0; i < getMaxDigit(); i++){
            countingSort(place);
            place *= 10;
        }
    }

    public void countingSort(int place){
        //additional memory
        int[] output = new int[data.length];
        int[] count = new int[ITEMS];
        //consider the items in the data in O(N)
        for(int i = 0; i < data.length; ++i){
            count[(data[i]/place) % ITEMS]++;
        }
        //transform the count array into a cumulative array O(K)
        for(int i = 1; i < count.length; ++i){
            count[i] = count[i] + count[i-1];
        }
        //cumulative array to get the positions of the items in the original (data)
        //consider the items in reverse order, right to left O(N)
        for(int i = data.length - 1; i >= 0; --i){//traversing from right to left
            //decrement the cumulative value, to preserve the relative position of elements
            count[(data[i]/place) % ITEMS]--;
            //by doing this, numbers are sorted and with relative positions
            output[count[(data[i]/place) % ITEMS]] = data[i];
        }
        //copy the sorted data into original array that is data array in our case
        for(int i = 0; i < data.length; ++i){
            data[i] = output[i];
        }
    }
    //find max item for given data set
    private int getMaxDigit(){
        int maxItem = Arrays.stream(data).max().getAsInt();
        //calculate the number of digits
        return String.valueOf(maxItem).length();
    }


    public static void main(String[] args) {
        //int[] data = {1, 6, 4, 0, 1, 8, 7, 3, 6, 1, 5};
        int[] data = {12, 56, 34, 99, 78, 0, 5, 4, 3, 1000, 700, 123, 878};
        RadixSort cs = new RadixSort(data);
        cs.print("Before sorting");
        cs.sort();
        cs.print("\n After sorting");
    }
}
