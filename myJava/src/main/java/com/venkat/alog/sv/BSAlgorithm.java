package com.venkat.alog.sv;

public class BSAlgorithm {
    public static int binarySearch(int[] arr, int left, int right, int x){
        if(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] == x){
                return mid;
            }if(arr[mid] <  x){
                return binarySearch(arr, mid + 1, right, x);
            }else{
                return binarySearch(arr, left, mid - 1, x);
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] array = {2, 3, 4, 10, 40};
        int target = 10;

        System.out.println(binarySearch(array, 0, array.length-1, target));
        //arr, left, right, x
    }
}
