package bcs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    String courseCode;
    String title;
    String description;
    int capacity;
    String schedule;

    Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }
}

class Student {
    int studentID;
    String name;
    List<Course> registeredCourses;

    Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }
}

public class CourseRegistrationSystem {
    private static List<Course> courses = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        initializeCourses();
        showCourseListing();

   
        Student student = new Student(101, "John Doe");
        registerForCourse(student, "CSE101");

        dropCourse(student, "CSE101");
    }

    private static void initializeCourses() {
        
        courses.add(new Course("CSE101", "Introduction to Computer Science", "Basic concepts of programming", 30, "Mon/Wed 10:00 AM"));
        
    }

    private static void showCourseListing() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println("Course Code: " + course.courseCode);
            System.out.println("Title: " + course.title);
            System.out.println("Description: " + course.description);
            System.out.println("Capacity: " + course.capacity);
            System.out.println("Schedule: " + course.schedule);
            System.out.println("-----------------------------");
        }
    }

    private static void registerForCourse(Student student, String courseCode) {
        Course selectedCourse = findCourse(courseCode);
        if (selectedCourse != null && selectedCourse.capacity > 0) {
            student.registeredCourses.add(selectedCourse);
            selectedCourse.capacity--;
            System.out.println(student.name + " successfully registered for " + selectedCourse.title);
        } else {
            System.out.println("Unable to register. Course not found or no available slots.");
        }
    }

    private static void dropCourse(Student student, String courseCode) {
        Course selectedCourse = findCourse(courseCode);
        if (selectedCourse != null && student.registeredCourses.contains(selectedCourse)) {
            student.registeredCourses.remove(selectedCourse);
            selectedCourse.capacity++;
            System.out.println(student.name + " successfully dropped " + selectedCourse.title);
        } else {
            System.out.println("Unable to drop. Course not found or not registered.");
        }
    }

    private static Course findCourse(String courseCode) {
        for (Course course : courses) {
            if (course.courseCode.equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
}