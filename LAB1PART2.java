package academy.javapro;

import java.util.*;
import java.util.stream.*;

class Student {
    private String name;
    private double gpa;
    private String year;

    public Student(String name, double gpa, String year) {
        this.name = name;
        this.gpa = gpa;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return name + " (" + year + ") - GPA: " + gpa;
    }
}

public class StudentStreamLab {
    public static void main(String[] args) {
        // Creating a list of students
        List<Student> students = Arrays.asList(
                new Student("Alice", 3.5, "Junior"),
                new Student("Bob", 3.8, "Senior"),
                new Student("Charlie", 2.9, "Sophomore"),
                new Student("David", 3.1, "Freshman"),
                new Student("Eve", 3.9, "Junior")
        );

        // Filtering: Students with GPA > 3.0
        List<Student> highGpaStudents = students.stream()
                .filter(s -> s.getGpa() > 3.0)
                .collect(Collectors.toList());

        System.out.println("Students with GPA > 3.0:");
        highGpaStudents.forEach(System.out::println);

        // Mapping: Extract names of students with GPA > 3.0
        List<String> highGpaStudentNames = students.stream()
                .filter(s -> s.getGpa() > 3.0)
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println("\nHigh GPA student names:");
        highGpaStudentNames.forEach(System.out::println);

        // Reducing: Calculate the average GPA of all students
        double averageGpa = students.stream()
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0);

        System.out.printf("\nAverage GPA: %.2f\n", averageGpa);

        // Collecting: Collect all "Junior" students into a list
        List<Student> juniors = students.stream()
                .filter(s -> s.getYear().equals("Junior"))
                .collect(Collectors.toList());

        System.out.println("\nJuniors:");
        juniors.forEach(System.out::println);
    }
}