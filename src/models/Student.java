package models;

import database.DatabaseOperations;

public class Student extends Person implements DatabaseOperations {
    private String id;
    private String course;
    private double marks;

    // Constructor calling the parent (super) class
    public Student(String name, String email, String id, String course, double marks) {
        super(name, email);
        this.id = id;
        this.course = course;
        this.marks = marks;
    }

    // Implementing the abstract method from Person
    @Override
    public void displayInfo() {
        System.out.println("Student ID: " + id + ", Name: " + name + ", Course: " + course);
    }

    // Implementing methods from DatabaseOperations interface
    // We leave them blank for now until we connect JDBC
    @Override
    public void add() {
        System.out.println("Adding student to database...");
    }

    @Override
    public void delete() {
        System.out.println("Deleting student from database...");
    }

    @Override
    public void update() {
        System.out.println("Updating student in database...");
    }

    @Override
    public void search(String keyword) {
        System.out.println("Searching for student: " + keyword);
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
    public double getMarks() { return marks; }
    public void setMarks(double marks) { this.marks = marks; }
}