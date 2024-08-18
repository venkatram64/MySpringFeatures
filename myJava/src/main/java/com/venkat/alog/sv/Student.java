package com.venkat.alog.sv;/*

package com.srijan;

import java.util.ArrayList;
import java.util.List;

public class Student {
    String name;
    List<Integer> marks;
    public Student(String name, List<Integer> marks){
        this.name = name;
        this.marks = marks;
    }
    public double calculateAvg(){
        int sum = 0;
        for(Integer mark : marks){
            sum += mark;
        }
        return (double)sum/marks.size();

    }
    public String determineGrade(){
        double avg = calculateAvg();
        if(avg >= 90){
            return "A";
        }else{
            return "B";
        }

    }
    public void printStudentDetails(){
        System.out.println("Name: " + name);
        System.out.println("Average: " + calculateAvg());
        System.out.println("Grade : " + determineGrade());
    }

    public static void main(String[] args) {
        String[][] data = {
                {"Andrew", "88", "99", "85"},
                {"Brian", "98", "75", "88"},
                {"Christian", "66", "68", "63"}
        };
        List<Student> students = new ArrayList<>();
        for(String[] studentData : data){
            String name =  studentData[0];
            List<Integer> marks = new ArrayList<>();
            for(int i = 1; i < studentData.length; i++){
                marks.add(Integer.parseInt(studentData[i]));
            }
            students.add(new Student(name, marks));
        }
        for(Student student : students){
            student.printStudentDetails();
            System.out.println();
        }
    }
}
*/

