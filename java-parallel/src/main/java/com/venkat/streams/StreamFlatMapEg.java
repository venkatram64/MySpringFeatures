package com.venkat.streams;

import java.util.*;
import java.util.stream.Collectors;

record TeamMember(String name, List<String> skills){};
record Project(String name, String department, List<TeamMember> team){};

record Employee(String name, String department, double salary){
    public static int salary(Employee o1, Employee o2) {
        return Double.compare(o1.salary(), o2.salary());
    }
    public static Comparator<Employee> bySalaryComparator() {
        return Comparator.comparingDouble(Employee::salary);
    }
};

record Person(String name, int age){};

public class StreamFlatMapEg {

    public static void skillByDepartment(){

        List<Project> projects = List.of(
                new Project("Project 1", "IT", List.of(
                        new TeamMember("John", List.of("Java", "Spring")),
                        new TeamMember("Jane", List.of("Python", "ML")))),
                new Project("Project 2", "HR", List.of(
                        new TeamMember("Mark", List.of("Excel", "Power BI")),
                        new TeamMember("Mike", List.of("Power BI", "MS SQL Server")))),
                new Project("Project 3", "IT", List.of(
                        new TeamMember("Ron", List.of("Java", "Spring Boot")),
                        new TeamMember("Dave", List.of("Scala", "Kafka"))))
        );


        Map<String, Set<String>> skillsByDepartment = projects.stream()
                .collect(Collectors.groupingBy(p -> p.department(),
                        Collectors.flatMapping(p -> p.team()
                                .stream().flatMap(member -> member.skills().stream()), Collectors.toSet())));

        System.out.println("Skills by department: " + skillsByDepartment);

    }

    private static void groupByFirstLetter(){

        List<String> words = Arrays.asList("apple", "banana", "apricot", "blueberry");
        Map<Character, List<String>> groupByFirstLetter = words.stream()
                .collect(Collectors.groupingBy(word -> word.charAt(0))); // {a=[apple, apricot], b=[banana, blueberry]
        System.out.println("Group by first letter: " + groupByFirstLetter);
    }

    private static void frequencyCountByWords(){

        List<String> words = Arrays.asList("apple", "banana", "apricot", "apple","blueberry");
        Map<String, Long> countByWords = words.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        System.out.println("Count by words: " + countByWords);
    }

    private static void findHighestSalaryByDepartment(){

        List<Employee> employees = List.of(
                new Employee("John", "IT", 50000),
                new Employee("Jane", "IT", 60000),
                new Employee("Mark", "HR", 70000),
                new Employee("Mike", "HR", 80000)
        );

        Map<String, Optional<Employee>> highestSalaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::department,
                                Collectors.maxBy(( o1,  o2) -> Employee.salary(o1, o2))));
        System.out.println("Highest salary by department: " + highestSalaryByDepartment);
    }

    private static void secondHighestSalary(){

        List<Employee> employees = List.of(
                new Employee("John", "IT", 50000),
                new Employee("Jane", "IT", 60000),
                new Employee("Mark", "HR", 70000),
                new Employee("Mike", "HR", 80000)
        );

        Optional<Employee> secondHighestSalary  = employees.stream()
                .sorted(Employee.bySalaryComparator().reversed())
                .skip(1)
                .findFirst();
        System.out.println("Second highest salary: " + secondHighestSalary);

    }

    private static void arrayFlatmap(){

        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("a", "b", "c"),
                Arrays.asList("d", "e", "f"),
                Arrays.asList("g", "h", "i")
        );

        List<String> flatList = nestedList.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());

        System.out.println("Flat list: " + flatList);
    }

    public static void personByName(){
        List<Person> persons = Arrays.asList(
                new Person("John", 25),
                new Person("John", 35),
                new Person("Jane", 30),
                new Person("Mark", 35),
                new Person("Mark", 40),
                new Person("Mike", 40)
        );

        Map<String, List<Integer>> personsByAge = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::name,
                        Collectors.mapping(Person::age, Collectors.toList()))
                );
        System.out.println("Persons by age: " + personsByAge);
    }

    public static void personByNameCount(){
        List<Person> persons = Arrays.asList(
                new Person("John", 25),
                new Person("John", 35),
                new Person("Jane", 30),
                new Person("Mark", 35),
                new Person("Mark", 40),
                new Person("Mike", 40)
        );

        Map<String, Long> personsNameCount = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::name,
                        Collectors.counting())
                );
        System.out.println("Persons by Name count: " + personsNameCount);
    }

    public static void personByNameIntegerCount(){
        List<Person> persons = Arrays.asList(
                new Person("John", 25),
                new Person("John", 35),
                new Person("Jane", 30),
                new Person("Mark", 35),
                new Person("Mark", 40),
                new Person("Mike", 40)
        );

        Map<String, Integer> personsNameCount = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::name,
                        Collectors.collectingAndThen(Collectors.counting(), value -> value.intValue()))
                );
        System.out.println("Persons by Name count: " + personsNameCount);
    }

    public static void main(String[] args) {

        skillByDepartment();
        groupByFirstLetter();
        frequencyCountByWords();
        findHighestSalaryByDepartment();
        arrayFlatmap();
        secondHighestSalary();
        personByName();
        personByNameCount();
    }
}
