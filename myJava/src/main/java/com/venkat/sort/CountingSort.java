package com.venkat.sort;

public class CountingSort {
    //considering single digits for sorting so
    private static final int ITEMS = 10;
    private int[] data;

    public CountingSort(int[] data){
        this.data = data;
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
        int[] count = new int[ITEMS];
        //consider the items in the data in O(N)
        for(int i = 0; i < data.length; ++i){
            count[data[i]]++;
        }
        //transform the count array into a cumulative array O(K)
        for(int i = 1; i < count.length; ++i){
            count[i] = count[i] + count[i-1];
        }
        //cumulative array to get the positions of the items in the original (data)
        //consider the items in reverse order, right to left O(N)
        for(int i = data.length - 1; i >= 0; --i){//traversing from right to left
            //decrement the cumulative value, to preserve the relative position of elements
            count[data[i]]--;
            //by doing this, numbers are sorted and with relative positions
            output[count[data[i]]] = data[i];
        }
        //copy the sorted data into original array that is data array in our case
        for(int i = 0; i < data.length; ++i){
            data[i] = output[i];
        }
    }

    public static void main(String[] args) {
        //int[] data = {1, 6, 4, 0, 1, 8, 7, 3, 6, 1, 5};
        int[] data = {1, 4, 1, 7, 1, 7, 9, 3, 8, 9, 6};
        CountingSort cs = new CountingSort(data);
        cs.print("Before sorting");
        cs.sort();
        cs.print("\n After sorting");
    }
}
