package com.example.jdbc.model;

public class Employee {
    private long ID;
    private double salary;
    private String name;

    public Employee(long ID, int salary, String name) {
        this.ID = ID;
        this.salary = salary;
        this.name = name;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
