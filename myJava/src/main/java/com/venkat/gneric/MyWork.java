package com.venkat.gneric;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/*
A List<Integer> is not a subtype of List<Number>
this is the reason why we need to consider wildcards


 */
class Person implements Comparable<Person>{
    private int age;
    private String name;

    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(age, o.age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}





public class MyWork {



    //bounded type parameter
    public static <T extends Comparable<T>> T calculateMin(T v, T v2){
        if(v.compareTo(v2) < 0){
            return v;
        }else{
            return v2;
        }
    }

    public static <T extends Number> double add(T t, T t2){
        return t.doubleValue() + t2.doubleValue();
    }

    public static <T extends Comparable<T>> int countGreaterItems(T[] items, T item){
        int count = 0;
        for(T it : items){
            if(item.compareTo(it) > 0){
                count++;
            }
        }
        return count;
    }

    /*
    A List<Integer> is not a subtype of List<?>
    we can print anything we want(integers, doubles, or strings)
    but we can not insert into this collection because we do not
    know the type
     */
    public static void print(Collection<?> c){
        for(Object o: c){
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        System.out.println(calculateMin(8, 7));

        System.out.println(calculateMin("Srijan", "Venkat"));

        System.out.println(calculateMin(new Person(23, "Srijan"), new Person(60, "Venkatram")));

        System.out.println();

        List<Integer> nums = Arrays.asList(1,2,3,4);
        print(nums);
    }
}
