package com.venkat.basic;

public class Customer {

    private String name;
    private double creditLimit;
    private String email;

    public Customer() {
        this("Nobody", "nobody@email.com");
    }

    public Customer(String name,  String email) {
        this(name, 1000.0, email);
    }

    public Customer(String name, double creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", creditLimit=" + creditLimit +
                ", email='" + email + '\'' +
                '}';
    }
}
