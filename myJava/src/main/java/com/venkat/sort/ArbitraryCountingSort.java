package com.venkat.sort;

import java.util.Arrays;

public class ArbitraryCountingSort {
    private int[] data;
    private int max;
    private int min;

    public ArbitraryCountingSort(int[] data){
        this.data = data;
        this.min = Arrays.stream(data).min().getAsInt();
        this.max = Arrays.stream(data).max().getAsInt();
    }

    private void print(String msg){
        System.out.println(msg);
        for(int i = 0; i < data.length; i++){
            System.out.print(data[i] + " ");
        }
    }

    public void sort(){
        //additional memory
        int[] output = new int[data.length];
        int[] count = new int[max - min + 1];
        //consider the items in the data in O(N)
        for(int i = 0; i < data.length; ++i){
            count[data[i] - min]++;
        }
        //transform the count array into a cumulative array O(K)
        for(int i = 1; i < count.length; ++i){
            count[i] = count[i] + count[i-1];
        }
        //cumulative array to get the positions of the items in the original (data)
        //consider the items in reverse order, right to left O(N)
        for(int i = data.length - 1; i >= 0; --i){
            count[data[i] - min]--;
            output[count[data[i] - min]] = data[i];
        }
        //copy the sorted data into original array that is data array in our case
        for(int i = 0; i < data.length; ++i){
            data[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] data = {12, 56, -34, 99};
        ArbitraryCountingSort cs = new ArbitraryCountingSort(data);
        cs.print("Before sorting");
        cs.sort();
        cs.print("\n After sorting");
    }
}
