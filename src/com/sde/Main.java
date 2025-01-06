package com.sde;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = StudentManager.getInstance();
        generateRandomStudents(manager, 5);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Get Student");
            System.out.println("4. Update Student");
            System.out.println("5. List All Students");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter school name:");
                    String schoolName = scanner.nextLine();
                    System.out.println("Enter address:");
                    String address = scanner.nextLine();
                    System.out.println("Enter age:");
                    int age = scanner.nextInt();
                    System.out.println("Enter year:");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Student student = StudentFactory.createStudent(name, schoolName, address, age, year);
                    manager.addStudent(student);
                    System.out.println("Student added.");
                    break;

                case 2:
                    System.out.println("Enter name of student to remove:");
                    String nameToRemove = scanner.nextLine();
                    manager.removeStudent(nameToRemove);
                    System.out.println("Student removed.");
                    break;

                case 3:
                    System.out.println("Enter name of student to get:");
                    String nameToGet = scanner.nextLine();
                    Student retrievedStudent = manager.getStudent(nameToGet);
                    if (retrievedStudent != null) {
                        System.out.println("Student found: " + retrievedStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.println("Enter name of student to update:");
                    String nameToUpdate = scanner.nextLine();
                    System.out.println("Enter new school name:");
                    String newSchoolName = scanner.nextLine();
                    System.out.println("Enter new address:");
                    String newAddress = scanner.nextLine();
                    System.out.println("Enter new age:");
                    int newAge = scanner.nextInt();
                    System.out.println("Enter new year:");
                    int newYear = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Student updatedStudent = StudentFactory.createStudent(nameToUpdate, newSchoolName, newAddress, newAge, newYear);
                    manager.updateStudent(nameToUpdate, updatedStudent);
                    System.out.println("Student updated.");
                    break;

                case 5:
                    System.out.println("All Students:");
                    for (Student s : manager.getAllStudents()) {
                        System.out.println(s);
                    }
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void generateRandomStudents(StudentManager manager, int count) {
        Random random = new Random();
        String[] names = {"John", "Jane", "Alex", "Chris", "Taylor"};
        String[] schoolNames = {"High School A", "High School B", "High School C"};
        String[] addresses = {"123 Main St", "456 Elm St", "789 Oak St"};

        for (int i = 0; i < count; i++) {
            String name = names[random.nextInt(names.length)] + " " + (char) (random.nextInt(26) + 'A') + ".";
            String schoolName = schoolNames[random.nextInt(schoolNames.length)];
            String address = addresses[random.nextInt(addresses.length)];
            int age = random.nextInt(5) + 14; // Age between 14 and 18
            int year = random.nextInt(4) + 9; // Year between 9 and 12

            Student student = StudentFactory.createStudent(name, schoolName, address, age, year);
            manager.addStudent(student);
        }
    }
}