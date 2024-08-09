package com.venkat.basic;

public class StudentMain {

    public static void main(String[] args) {
        for(int i = 0; i <= 5; i++){
            Student s = new Student("VV100" + i,
                        switch(i) {
                            case 1 -> "Mary";
                            case 2 -> "Carol";
                            case 3 -> "Tim";
                            case 4 -> "Harry";
                            case 5 -> "Lisa";
                            default -> "Anonymous";
                        },
                    "04/12/1980",
                    "Java Masterclass"
                    );
        }
    }
}
