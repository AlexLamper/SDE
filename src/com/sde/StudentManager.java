package com.sde;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private static StudentManager instance;
    private List<Student> students;

    private StudentManager() {
        students = new ArrayList<>();
    }

    public static StudentManager getInstance() {
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String name) {
        students.removeIf(student -> student.getName().equals(name));
    }

    public Student getStudent(String name) {
        return students.stream()
                .filter(student -> student.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public void updateStudent(String name, Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name)) {
                students.set(i, updatedStudent);
                break;
            }
        }
    }
}