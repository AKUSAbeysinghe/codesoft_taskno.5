//TASK 05 - STUDENT MANAGEMENT SYSTEM
//CODESOFT



import java.util.Scanner;

class Student {
    String name;
    int rollNumber;
    String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }
}

public class StudentManagementSystem {
    private static final int MAX_STUDENTS = 100;
    private static Student[] students = new Student[MAX_STUDENTS];
    private static int studentCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Student Management System!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search for Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addStudent() {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("Maximum number of students reached.");
            return;
        }

        System.out.print("Enter name: ");
        String name = scanner.next();

        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();

        System.out.print("Enter grade: ");
        String grade = scanner.next();

        students[studentCount++] = new Student(name, rollNumber, grade);
        System.out.println("Student added successfully.");
    }

    private static void removeStudent() {
        System.out.print("Enter roll number of student to remove: ");
        int rollNumber = scanner.nextInt();

        for (int i = 0; i < studentCount; i++) {
            if (students[i].rollNumber == rollNumber) {
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1];
                }
                studentCount--;
                System.out.println("Student removed successfully.");
                return;
            }
        }

        System.out.println("Student not found with given roll number.");
    }

    private static void searchStudent() {
        System.out.print("Enter roll number of student to search: ");
        int rollNumber = scanner.nextInt();

        for (int i = 0; i < studentCount; i++) {
            if (students[i].rollNumber == rollNumber) {
                System.out.println("Student found:");
                System.out.println("Name: " + students[i].name);
                System.out.println("Roll Number: " + students[i].rollNumber);
                System.out.println("Grade: " + students[i].grade);
                return;
            }
        }

        System.out.println("Student not found with given roll number.");
    }

    private static void displayAllStudents() {
        if (studentCount == 0) {
            System.out.println("No students added yet.");
            return;
        }

        System.out.println("All Students:");
        for (int i = 0; i < studentCount; i++) {
            System.out.println("Name: " + students[i].name + ", Roll Number: " + students[i].rollNumber + ", Grade: " + students[i].grade);
        }
    }
}

