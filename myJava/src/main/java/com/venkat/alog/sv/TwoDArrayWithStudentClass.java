package com.venkat.alog.sv;

public class TwoDArrayWithStudentClass {
    public static void main(String[] args){
        String[][] scores = {
                {"Charles", "63"},
                {"Bob", "85"},
                {"Mark", "100"},
                {"Mark", "34"}
        };
        Student bestStudent = bestAvgCal(scores);
        System.out.println("Best average student: " + bestStudent.getName() + " with average score: " + bestStudent.getAverage());

    }

    public static Student bestAvgCal(String[][] scores){
        Student[] students = new Student[scores.length];
        int index = 0;

        for(String[] score : scores){
            String name = score[0];
            int currentScore = Integer.parseInt(score[1]);
            boolean found = false;
            for(int i = 0; i < index; i++){
                if(students[i].getName().equals(name)){
                    students[i].addScore(currentScore);
                    found = true;
                    break;
                }
            }
            if(!found){
                students[index] = new Student(name, currentScore);
                index++;
            }
        }

        Student bestStudent = students[0];
        for(int i = 1; i < index; i++){
            if(students[i].getAverage() > bestStudent.getAverage()){
                bestStudent = students[i];
            }
        }
        return bestStudent;
    }
}

class Student {
    private String name;
    private int totalScore;
    private int count;

    public Student(String name, int initialScore) {
        this.name = name;
        this.totalScore = initialScore;
        this.count = 1;
    }

    public void addScore(int score) {
        this.totalScore += score;
        this.count++;
    }

    public String getName() {
        return name;
    }

    public double getAverage() {
        return (double) totalScore / count;
    }
}
