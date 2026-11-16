package com.mycompany.campussystem.model;

/** Booking priority. A lower level is served first. */
public enum BookingPriority {
    EXAM(1), LECTURE(2), STUDY_GROUP(3);

    private final int level;

    BookingPriority(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
