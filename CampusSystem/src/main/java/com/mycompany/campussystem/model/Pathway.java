package com.mycompany.campussystem.model;

/** A two-way walking path between two buildings. It is an edge in the campus graph. */
public class Pathway {

    private Building from;
    private Building to;
    private double distance; // metres

    public Pathway(Building from, Building to, double distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    public Building getFrom() { return from; }
    public Building getTo() { return to; }
    public double getDistance() { return distance; }

    /** Returns the building at the other end of this pathway from b. */
    public Building getOther(Building b) {
        return b == from ? to : from;
    }

    @Override
    public String toString() {
        return from.getId() + " <-> " + to.getId() + " (" + distance + " m)";
    }
}
