package com.sde;

public class StudentFactory {
    public static Student createStudent(String name, String schoolName, String address, int age, int year) {
        return new Student(name, schoolName, address, age, year);
    }
}