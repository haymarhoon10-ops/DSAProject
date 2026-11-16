package com.mycompany.campussystem.model;

import java.util.ArrayList;

/** A course with one or more weekly time slots. */
public class Course {

    private String courseCode;
    private String title;
    private ArrayList<TimeSlot> slots = new ArrayList<>();

    public Course(String courseCode, String title) {
        this.courseCode = courseCode;
        this.title = title;
    }

    public String getCourseCode() { return courseCode; }
    public String getTitle() { return title; }
    public ArrayList<TimeSlot> getSlots() { return slots; }

    public void addSlot(TimeSlot s) {
        slots.add(s);
    }

    /** True if any slot of this course overlaps any slot of the other course. */
    public boolean clashesWith(Course other) {
        for (TimeSlot a : slots) {
            for (TimeSlot b : other.slots) {
                if (a.overlaps(b)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return courseCode + " " + title;
    }
}
