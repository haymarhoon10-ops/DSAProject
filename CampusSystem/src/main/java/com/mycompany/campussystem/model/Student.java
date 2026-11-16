package com.mycompany.campussystem.model;

import java.util.ArrayList;

/** A student who can enrol in courses and make booking requests. */
public class Student {

    private String studentId;
    private String name;
    private ArrayList<Course> courses = new ArrayList<>();

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public ArrayList<Course> getCourses() { return courses; }

    public void enrol(Course c) {
        courses.add(c);
    }

    @Override
    public String toString() {
        return studentId + " " + name;
    }
}
