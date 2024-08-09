package com.venkat.gneric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpperBound {

    //insert/add
    //lower bounded wild cards
    public static void add(List<? super Number> list, int[] nums){
        for(Number i : nums){
            list.add(i);
        }
    }

    //get
    //upper bounded wild cards
    public static void read(List<? extends Number> list){
        for(Number i: list){
            System.out.println(i);
        }
    }

    //read/write
    public static <T> void copy(List<? extends T> source, List<? super T> destination){
        for(int i = 0; i < source.size(); i++){
            destination.add(source.get(i));
        }
    }

    public static void main(String[] args) {
        List<? super Number> list = new ArrayList<>();
        int[] nums = {1,2,3,4,5};
        add(list, nums);
        System.out.println("Size is " + list.size());
        //read(list);

        List<? extends Number> doubles = Arrays.asList(1.1f, 2, 2f, 3.3f, 4.4f);
        read(doubles);

        List<String> source = Arrays.asList("Venkat", "Anitha", "Vinny", "Srijan");
        List<String> destination = new ArrayList<>();
        copy(source, destination);
        for(String s: destination){
            System.out.println(s);
        }
    }

}
