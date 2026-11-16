package com.mycompany.campussystem.model;

/**
 * A student's request to book a room.
 * Ordering: higher priority first (EXAM, then LECTURE, then STUDY_GROUP), ties broken by earlier time.
 */
public class Request implements Comparable<Request> {

    private int requestId;
    private Student student;
    private Room room;
    private BookingPriority priority;
    private long timestamp;

    public Request(int requestId, Student student, Room room, BookingPriority priority, long timestamp) {
        this.requestId = requestId;
        this.student = student;
        this.room = room;
        this.priority = priority;
        this.timestamp = timestamp;
    }

    public int getRequestId() { return requestId; }
    public Student getStudent() { return student; }
    public Room getRoom() { return room; }
    public BookingPriority getPriority() { return priority; }
    public long getTimestamp() { return timestamp; }

    @Override
    public int compareTo(Request other) {
        if (priority.getLevel() != other.priority.getLevel()) {
            return Integer.compare(priority.getLevel(), other.priority.getLevel());
        }
        return Long.compare(timestamp, other.timestamp);
    }

    @Override
    public String toString() {
        return "Request #" + requestId + " by " + student.getStudentId()
                + " for " + room.getRoomId() + " (" + priority + ")";
    }
}
