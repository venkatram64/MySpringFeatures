package com.venkat.basic;

public class SwitchEg {

    public static void tSwith1(String str){
        char c = str.charAt(0);
        switch(c){
            case 'A':
                System.out.println("NATO word is " + str);
                break;
            case 'B':
                System.out.println("NATO word is " + str);
                break;
            case 'C':
                System.out.println("NATO word is " + str);
                break;
            case 'D':
                System.out.println("NATO word is " + str);
                break;
            case 'E':
                System.out.println("NATO word is " + str);
                break;
            default:
                System.out.println("It is not NATO word is " + str);
        }
    }

    public static void dayOfWeek(int day){
        String dayOfWeek = switch(day) {
            case 0 -> "Sunday";
            case 1 -> {yield "Monday";}
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default ->"Not valid day";
        };
        System.out.println(dayOfWeek);
    }


    private static boolean isLeapYear(int year){
        if(year < 1 || year > 9999){
            return false;
        }
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public static int getDaysInMonth(int month, int year){

        if(year < 1 || year > 9999){
            return -1;
        }

        return switch(month){
            case 1,3,5,7,8,10,12 -> 31;
            case 2 -> {yield  isLeapYear(year) ? 29 : 28 ;  }
            case 4,6,9,11 -> 30;
            default -> -1;
        };
    }

    public static void main(String[] args) {
        tSwith1("Able");
        dayOfWeek(4);

        int days = getDaysInMonth(2, 2023);
        System.out.println("Month days " + days);
        days = getDaysInMonth(2, 2020);
        System.out.println("Month days " + days);

        days = getDaysInMonth(12, 10_000);
        System.out.println("Month days " + days);
    }
}
