package com.mycompany.campussystem.model;

/** A building on campus. It is a vertex in the campus graph. */
public class Building {

    private String id;
    private String name;
    private String description;

    public Building(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return id + " (" + name + ")";
    }
}
