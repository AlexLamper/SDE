package com.sde;

public class Student {
    private String name;
    private String schoolName;
    private String address;
    private int age;
    private int year;

    public Student(String name, String schoolName, String address, int age, int year) {
        this.name = name;
        this.schoolName = schoolName;
        this.address = address;
        this.age = age;
        this.year = year;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSchoolName() { return schoolName; }
    public void setSchoolName(String schoolName) { this.schoolName = schoolName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    @Override
    public String toString() {
        return "Name: " + name + ", School: " + schoolName + ", Address: " + address + ", Age: " + age + ", Year: " + year;
    }
}