package com.mycompany.campussystem.service;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import com.mycompany.campussystem.model.*;

/**
 * Creates all the sample campus data in code (no files needed).
 * Bahrain Polytechnic buildings: 15 locations, 25 two-way pathways (distances approximate), 72 rooms (Building 5 labs 2-10, Building 20 labs 100-120, Building 19 classrooms 100-120 and 300-320), 8 courses.
 *
 * Built-in test cases:
 *  - G1 -> B19: direct path is 420 m, detour via B11 is 310 m (Dijkstra must pick the detour)
 *  - MUH Muharraq Campus is a separate campus with no walking path (the "no route" case)
 *  - B5-003 is full, for the waiting list test
 *  - Clashes: IT7011/IT8118, IT8118/IT8101, IT8108/IT8415
 */
public class DataLoader {

    private final ArrayList<Building> buildings = new ArrayList<>();
    private final ArrayList<Pathway> pathways = new ArrayList<>();
    private final ArrayList<Room> rooms = new ArrayList<>();
    private final ArrayList<Course> courses = new ArrayList<>();

    public DataLoader() {
        loadBuildings();
        loadPathways();
        loadRooms();
        loadCourses();
    }

    public ArrayList<Building> getBuildings() { return buildings; }
    public ArrayList<Pathway> getPathways() { return pathways; }
    public ArrayList<Room> getRooms() { return rooms; }
    public ArrayList<Course> getCourses() { return courses; }

    /** Finds a building in the list by its ID, or returns null. */
    public Building findBuilding(String id) {
        for (Building b : buildings) {
            if (b.getId().equals(id)) {
                return b;
            }
        }
        return null;
    }

    private void loadBuildings() {
        buildings.add(new Building("G1", "Main Entrance (Gate 1)", "Main Entrance (Gate 1)"));
        buildings.add(new Building("B11", "Bldg 11: HR, Finance & Classrooms", "Bldg 11: HR, Finance & Classrooms"));
        buildings.add(new Building("B19", "Bldg 19: Library & Classrooms", "Bldg 19: Library & Classrooms"));
        buildings.add(new Building("B20", "Bldg 20: Eng. Workshop & Labs", "Bldg 20: Eng. Workshop & Labs"));
        buildings.add(new Building("B05", "Bldg 5: IT Labs", "Bldg 5: IT Labs"));
        buildings.add(new Building("B24", "Bldg 24: Student Lounge & Eng. Labs", "Bldg 24: Student Lounge & Eng. Labs"));
        buildings.add(new Building("B08", "Bldg 8: Academics & Registry", "Bldg 8: Academics & Registry"));
        buildings.add(new Building("B09", "Bldg 9: ICT Services", "Bldg 9: ICT Services"));
        buildings.add(new Building("B12", "Bldg 12: Bahrain Hall", "Bldg 12: Bahrain Hall"));
        buildings.add(new Building("B36", "Bldg 36: Workshop & IT Labs", "Bldg 36: Workshop & IT Labs"));
        buildings.add(new Building("B30", "Bldg 30: Eng. Workshop", "Bldg 30: Eng. Workshop"));
        buildings.add(new Building("B16", "Bldg 16: Gym", "Bldg 16: Gym"));
        buildings.add(new Building("B25", "Bldg 25: Medical Clinic", "Bldg 25: Medical Clinic"));
        buildings.add(new Building("B26A", "Bldg 26-A: Cafeteria", "Bldg 26-A: Cafeteria"));
        buildings.add(new Building("MUH", "Muharraq Campus", "Separate campus, no walking path"));
    }

    /** Pathways are two-way (undirected), so each one is listed only once. */
    private void addPathway(String from, String to, double distance) {
        pathways.add(new Pathway(findBuilding(from), findBuilding(to), distance));
    }

    private void loadPathways() {
        addPathway("G1", "B11", 140);
        addPathway("B11", "B19", 170);
        addPathway("B11", "B08", 170);
        addPathway("B11", "B16", 180);
        addPathway("B19", "B20", 170);
        addPathway("B19", "B05", 200);
        addPathway("B20", "B05", 150);
        addPathway("B20", "B24", 170);
        addPathway("B05", "B24", 190);
        addPathway("B05", "B08", 190);
        addPathway("B05", "B09", 150);
        addPathway("B05", "B12", 170);
        addPathway("B24", "B36", 170);
        addPathway("B08", "B09", 170);
        addPathway("B08", "B16", 160);
        addPathway("B09", "B12", 180);
        addPathway("B09", "B25", 180);
        addPathway("B12", "B36", 150);
        addPathway("B12", "B25", 180);
        addPathway("B36", "B30", 200);
        addPathway("B30", "B25", 160);
        addPathway("B16", "B09", 300);
        addPathway("B19", "B26A", 140);
        addPathway("G1", "B19", 420);  // long winding path: the detour is shorter
        addPathway("B11", "B05", 520);  // long winding path: the detour is shorter
    }

    private void addRoom(String id, String buildingId, RoomType type,
                         int capacity, boolean available, int popularity) {
        Room r = new Room(id, findBuilding(buildingId), type, capacity, popularity);
        r.setAvailable(available);
        rooms.add(r);
    }

    private void loadRooms() {
        // id, building, type, capacity, available, popularity (0-100)
        addRoom("B5-002", "B05", RoomType.LAB, 20, true, 62);
        addRoom("B5-003", "B05", RoomType.LAB, 20, false, 97);
        addRoom("B5-004", "B05", RoomType.LAB, 20, true, 81);
        addRoom("B5-005", "B05", RoomType.LAB, 20, true, 53);
        addRoom("B5-006", "B05", RoomType.LAB, 20, true, 77);
        addRoom("B5-007", "B05", RoomType.LAB, 20, false, 51);
        addRoom("B5-008", "B05", RoomType.LAB, 20, true, 52);
        addRoom("B5-009", "B05", RoomType.LAB, 20, true, 73);
        addRoom("B5-010", "B05", RoomType.LAB, 20, true, 66);
        addRoom("B20-100", "B20", RoomType.LAB, 16, true, 90);
        addRoom("B20-101", "B20", RoomType.LAB, 16, true, 64);
        addRoom("B20-102", "B20", RoomType.LAB, 24, true, 48);
        addRoom("B20-103", "B20", RoomType.LAB, 16, true, 21);
        addRoom("B20-104", "B20", RoomType.LAB, 20, false, 60);
        addRoom("B20-105", "B20", RoomType.LAB, 20, true, 34);
        addRoom("B20-106", "B20", RoomType.LAB, 16, true, 34);
        addRoom("B20-107", "B20", RoomType.LAB, 20, true, 20);
        addRoom("B20-108", "B20", RoomType.LAB, 20, true, 39);
        addRoom("B20-109", "B20", RoomType.LAB, 16, true, 43);
        addRoom("B20-110", "B20", RoomType.LAB, 24, true, 81);
        addRoom("B20-111", "B20", RoomType.LAB, 20, true, 66);
        addRoom("B20-112", "B20", RoomType.LAB, 16, true, 90);
        addRoom("B20-113", "B20", RoomType.LAB, 24, true, 54);
        addRoom("B20-114", "B20", RoomType.LAB, 20, true, 43);
        addRoom("B20-115", "B20", RoomType.LAB, 24, false, 84);
        addRoom("B20-116", "B20", RoomType.LAB, 20, true, 73);
        addRoom("B20-117", "B20", RoomType.LAB, 20, true, 63);
        addRoom("B20-118", "B20", RoomType.LAB, 16, true, 53);
        addRoom("B20-119", "B20", RoomType.LAB, 24, true, 20);
        addRoom("B20-120", "B20", RoomType.LAB, 20, true, 50);
        addRoom("B19-100", "B19", RoomType.CLASSROOM, 30, true, 83);
        addRoom("B19-101", "B19", RoomType.CLASSROOM, 15, true, 71);
        addRoom("B19-102", "B19", RoomType.CLASSROOM, 30, false, 31);
        addRoom("B19-103", "B19", RoomType.CLASSROOM, 35, true, 21);
        addRoom("B19-104", "B19", RoomType.CLASSROOM, 35, true, 51);
        addRoom("B19-105", "B19", RoomType.CLASSROOM, 30, true, 54);
        addRoom("B19-106", "B19", RoomType.CLASSROOM, 30, true, 38);
        addRoom("B19-107", "B19", RoomType.CLASSROOM, 30, true, 47);
        addRoom("B19-108", "B19", RoomType.CLASSROOM, 30, true, 65);
        addRoom("B19-109", "B19", RoomType.CLASSROOM, 20, true, 31);
        addRoom("B19-110", "B19", RoomType.CLASSROOM, 35, false, 70);
        addRoom("B19-111", "B19", RoomType.CLASSROOM, 25, true, 29);
        addRoom("B19-112", "B19", RoomType.CLASSROOM, 25, true, 10);
        addRoom("B19-113", "B19", RoomType.CLASSROOM, 30, true, 78);
        addRoom("B19-114", "B19", RoomType.CLASSROOM, 25, true, 69);
        addRoom("B19-115", "B19", RoomType.CLASSROOM, 30, true, 62);
        addRoom("B19-116", "B19", RoomType.CLASSROOM, 25, true, 71);
        addRoom("B19-117", "B19", RoomType.CLASSROOM, 30, true, 41);
        addRoom("B19-118", "B19", RoomType.CLASSROOM, 20, true, 36);
        addRoom("B19-119", "B19", RoomType.CLASSROOM, 25, true, 52);
        addRoom("B19-120", "B19", RoomType.CLASSROOM, 30, true, 17);
        addRoom("B19-300", "B19", RoomType.CLASSROOM, 35, true, 48);
        addRoom("B19-301", "B19", RoomType.CLASSROOM, 15, true, 66);
        addRoom("B19-302", "B19", RoomType.CLASSROOM, 15, true, 69);
        addRoom("B19-303", "B19", RoomType.CLASSROOM, 30, true, 15);
        addRoom("B19-304", "B19", RoomType.CLASSROOM, 30, true, 62);
        addRoom("B19-305", "B19", RoomType.CLASSROOM, 35, false, 76);
        addRoom("B19-306", "B19", RoomType.CLASSROOM, 25, true, 24);
        addRoom("B19-307", "B19", RoomType.CLASSROOM, 25, true, 55);
        addRoom("B19-308", "B19", RoomType.CLASSROOM, 30, true, 46);
        addRoom("B19-309", "B19", RoomType.CLASSROOM, 15, true, 77);
        addRoom("B19-310", "B19", RoomType.CLASSROOM, 35, true, 50);
        addRoom("B19-311", "B19", RoomType.CLASSROOM, 25, true, 78);
        addRoom("B19-312", "B19", RoomType.CLASSROOM, 35, true, 46);
        addRoom("B19-313", "B19", RoomType.CLASSROOM, 30, true, 25);
        addRoom("B19-314", "B19", RoomType.CLASSROOM, 20, true, 43);
        addRoom("B19-315", "B19", RoomType.CLASSROOM, 30, true, 50);
        addRoom("B19-316", "B19", RoomType.CLASSROOM, 30, true, 63);
        addRoom("B19-317", "B19", RoomType.CLASSROOM, 30, true, 15);
        addRoom("B19-318", "B19", RoomType.CLASSROOM, 25, false, 58);
        addRoom("B19-319", "B19", RoomType.CLASSROOM, 20, true, 71);
        addRoom("B19-320", "B19", RoomType.CLASSROOM, 35, true, 81);
    }

    private TimeSlot slot(DayOfWeek day, String start, String end) {
        return new TimeSlot(day, LocalTime.parse(start), LocalTime.parse(end));
    }

    private void loadCourses() {
        Course it7011 = new Course("IT7011", "Data Structures & Algorithms");
        it7011.addSlot(slot(DayOfWeek.SUNDAY, "10:00", "11:30"));
        it7011.addSlot(slot(DayOfWeek.TUESDAY, "10:00", "11:30"));
        courses.add(it7011);

        Course it8118 = new Course("IT8118", "Advanced Programming");
        it8118.addSlot(slot(DayOfWeek.SUNDAY, "11:00", "12:30"));
        it8118.addSlot(slot(DayOfWeek.TUESDAY, "11:30", "13:00"));
        courses.add(it8118);

        Course it7006 = new Course("IT7006", "Object Oriented Design");
        it7006.addSlot(slot(DayOfWeek.SUNDAY, "08:30", "10:00"));
        it7006.addSlot(slot(DayOfWeek.TUESDAY, "08:30", "10:00"));
        courses.add(it7006);

        Course it8108 = new Course("IT8108", "Mobile Programming");
        it8108.addSlot(slot(DayOfWeek.MONDAY, "14:00", "15:30"));
        it8108.addSlot(slot(DayOfWeek.WEDNESDAY, "14:00", "15:30"));
        courses.add(it8108);

        Course it7009 = new Course("IT7009", "Artificial Intelligence");
        it7009.addSlot(slot(DayOfWeek.MONDAY, "10:00", "11:30"));
        it7009.addSlot(slot(DayOfWeek.WEDNESDAY, "10:00", "11:30"));
        courses.add(it7009);

        Course it8101 = new Course("IT8101", "Games Development");
        it8101.addSlot(slot(DayOfWeek.THURSDAY, "09:00", "10:30"));
        it8101.addSlot(slot(DayOfWeek.SUNDAY, "12:00", "13:30"));
        courses.add(it8101);

        Course it8415 = new Course("IT8415", "Database Programming 2");
        it8415.addSlot(slot(DayOfWeek.MONDAY, "14:00", "15:30"));
        it8415.addSlot(slot(DayOfWeek.THURSDAY, "13:00", "14:30"));
        courses.add(it8415);

        Course it7005 = new Course("IT7005", "Database Systems 2");
        it7005.addSlot(slot(DayOfWeek.MONDAY, "08:30", "10:00"));
        it7005.addSlot(slot(DayOfWeek.WEDNESDAY, "08:30", "10:00"));
        courses.add(it7005);
    }
}
