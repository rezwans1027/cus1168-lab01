package academy.javapro;

import java.util.*;
import java.util.stream.*;

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

        List<Student> highGPAStudents = students.stream()
                .filter(student -> student.getGpa() > 3.0)
                .collect(Collectors.toList());

        List<String> highGPAStudentNames = highGPAStudents.stream()
                .map(student -> student.getName())
                .collect(Collectors.toList());

        double averageGPA = students.stream()
                .mapToDouble(student -> student.getGpa())
                .average()
                .orElse(0.0);

        List<Student> juniors = highGPAStudents.stream()
                .filter(student -> student.getCollegeYear().equals("Junior"))
                .collect(Collectors.toList());

        System.out.println("Students with GPA > 3.0:");
        highGPAStudents.forEach(student -> System.out.println(student));

        System.out.println("\nHigh GPA student names:");
        highGPAStudentNames.forEach(System.out::println);

        System.out.println("\nAverage GPA: " + averageGPA);

        System.out.println("\nJuniors:");
        juniors.forEach(student -> System.out.println(student));
    }
}
