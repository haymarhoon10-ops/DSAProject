package com.mycompany.campussystem.model;

/** A bookable room (classroom, lab or study room). Rooms compare by room ID. */
public class Room implements Comparable<Room> {

    private String roomId;
    private Building building;
    private RoomType type;
    private int capacity;
    private boolean available;
    private int popularity; // 0-100, how often it gets booked

    public Room(String roomId, Building building, RoomType type, int capacity, int popularity) {
        this.roomId = roomId;
        this.building = building;
        this.type = type;
        this.capacity = capacity;
        this.popularity = popularity;
        this.available = true;
    }

    public String getRoomId() { return roomId; }
    public Building getBuilding() { return building; }
    public RoomType getType() { return type; }
    public int getCapacity() { return capacity; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    public int getPopularity() { return popularity; }

    public void incrementPopularity() {
        if (popularity < 100) {
            popularity++;
        }
    }

    @Override
    public int compareTo(Room other) {
        return roomId.compareTo(other.roomId);
    }

    @Override
    public String toString() {
        return roomId + " [" + type + ", cap " + capacity + ", "
                + (available ? "available" : "full") + ", popularity " + popularity + "]";
    }
}
