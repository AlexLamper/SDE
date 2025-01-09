package com.sde;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private static StudentManager instance;
    private List<Student> students;
    private NotificationService notificationService;

    private StudentManager() {
        students = new ArrayList<>();
        notificationService = new NotificationService();
    }

    public void addObserver(StudentObserver observer) {
        notificationService.addObserver(observer);
    }

    public void removeObserver(StudentObserver observer) {
        notificationService.removeObserver(observer);
    }

    public static StudentManager getInstance() {
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public void addStudent(Student student) {
        students.add(student);
        notificationService.notifyObservers("Student added: " + student.getName());
    }

    public void removeStudent(String name) {
        students.removeIf(student -> {
            boolean match = student.getName().equals(name);
            if (match) {
                notificationService.notifyObservers("Student removed: " + name);
            }
            return match;
        });
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
                notificationService.notifyObservers("Student updated: " + name);
                break;
            }
        }
    }
}