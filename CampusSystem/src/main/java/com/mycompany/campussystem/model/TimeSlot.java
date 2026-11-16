package com.mycompany.campussystem.model;

import java.time.DayOfWeek;
import java.time.LocalTime;

/** A weekly class time, e.g. Sunday 10:00-11:30. */
public class TimeSlot {

    private DayOfWeek day;
    private LocalTime start;
    private LocalTime end;

    public TimeSlot(DayOfWeek day, LocalTime start, LocalTime end) {
        this.day = day;
        this.start = start;
        this.end = end;
    }

    public DayOfWeek getDay() { return day; }
    public LocalTime getStart() { return start; }
    public LocalTime getEnd() { return end; }

    /** True if both slots are on the same day and overlap. Slots that only touch (10:00 end, 10:00 start) do not overlap. */
    public boolean overlaps(TimeSlot other) {
        return day == other.day && start.isBefore(other.end) && other.start.isBefore(end);
    }

    @Override
    public String toString() {
        return day + " " + start + "-" + end;
    }
}
