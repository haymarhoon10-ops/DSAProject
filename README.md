# 🧭 Smart Campus Navigation (Bahrain Polytechnic): A+ Milestones, v2

**IT7011 · Java (NetBeans) · Group of 3–5**
Rubric: System Design 20% · Data Structures 25% · Algorithms 25% · Complexity Analysis 20% · Documentation 10%

> **Submission:** the leader submits ONE **ZIP** (RAR gets 0) named `StreamNo_LeaderID` (e.g. `01_202312345`), containing the Java files and a **.docx** report of 10–15 pages, with a cover page listing every member's full name and ID.
> **Still to ask your lecturer:** the deadline and late penalty · whether Java's built-in `HashMap`/`PriorityQueue` are allowed (writing your own is the safe choice). **Decided:** console menu (what the course always uses).

**What changed in v2:** the campus is now real Bahrain Polytechnic buildings · all data is created in code by `DataLoader.java` (no files to read) · the courses are from your IT programme · the UML class diagram covers the real-world classes only.

---

## M1 · Scope and campus data 🗺️ (mostly done ✅)
- [x] Topic: Smart Campus Navigation, using Bahrain Polytechnic (Isa Town)
- [x] Campus graph: 15 locations and 25 two-way pathways → `docs/campus_map.png`
  - [x] Detour test: Main Gate → Bldg 19 is 420 m direct, but 310 m via Bldg 11
  - [x] "No route" test: Muharraq Campus (a separate campus with no walking path)
  - [x] Undirected, because people can walk paths both ways
- [x] Rooms: 72 in total. Bldg 5 labs 002–010, Bldg 20 labs 100–120, Bldg 19 classrooms 100–120 and 300–320
- [x] Timetable: 8 programme courses including IT7011 DSA, with 3 clashes
- [x] `DataLoader.java` creates all of this in code → `service/DataLoader.java`
- [ ] Optional: measure real distances on Google Maps and replace the approximate ones
- [ ] Optional: add a few study rooms (the brief mentions them)
- [ ] Ask your lecturer the 3 questions above
- [x] NetBeans project `SmartCampus` with packages `model`, `ds`, `algo`, `service`, `ui`, `test`, on JDK 17
- [ ] Push to GitHub, and have every member clone it and build it once

**✅ Done when:** every member can open and build the empty project.

---

## M2 · Design before code 📐
- [ ] **UML class diagram** (you draw it) of the real-world classes: Building, Pathway, Room, Student, Course, TimeSlot, Request, Booking, plus the enums RoomType, BookingPriority and BookingStatus
- [ ] Architecture diagram: UI → Services → Data structures and algorithms → DataLoader
- [ ] **Structure → feature justification table** (why each one fits, and what you rejected):

| Feature | Structure | Justification |
|---|---|---|
| Resource storage | Hash table | O(1) average lookup by room ID, vs O(n) to scan a list |
| Booking queue | Priority queue / heap | Highest priority served first, O(log n) insert and extract |
| Navigation map | Graph (adjacency list) | The campus is sparse, so a list beats an O(V²) matrix |
| Navigation history | Stack | "Back" returns the last place visited first (LIFO) |
| Student requests | Queue | Fair first-come, first-served (FIFO) |
| Resource categories | BST | Sorted browsing with an in-order traversal |

- [ ] Booking priority rule: EXAM > LECTURE > STUDY_GROUP, with ties broken by earlier request time
- [ ] Sketch the main menu: one option per feature, plus Back/History and Exit

**✅ Done when:** someone outside the team could build it from your diagrams.

---

## M3 · Model classes and the six data structures 🧱
- [x] Model classes written and `DataLoader` compiles
- [ ] **HashTable<K,V>**: hash, chaining, put/get/remove, resize
- [ ] **MinHeap**: insert, extractMin, peek, siftUp/siftDown (Dijkstra reuses it)
- [ ] **Graph**: addBuilding, addPathway (add the pathway to BOTH buildings), neighbours
- [ ] **Stack**: navigation history · **Queue** (linked list): student requests
- [ ] **BST**: insert, search, in-order traversal for room categories
- [ ] Fill the structures from `DataLoader` at startup
- [ ] A small test for each structure, including the empty case and a single element

**✅ Done when:** each structure passes its own tests before any feature uses it.

---

## M4 · Algorithms ⚙️
- [ ] **Dijkstra** with your heap. Return the full path and the total distance. Handle same start and end, no route, and unknown IDs
- [ ] **BFS**: the route with the fewest stops, or buildings within N hops
- [ ] **DFS**: timetable conflict groups on the course conflict graph
- [ ] **Merge sort or quick sort** by capacity, availability or popularity
- [ ] **Binary search** (on the sorted list) and **linear search** (on the unsorted list)

**✅ Done when:** these match the hand-checked answers:

| From → To | Expected path | Distance |
|---|---|---|
| G1 → B19 | G1 → B11 → B19 | 310 m (not the 420 m direct path) |
| B11 → B05 | B11 → B08 → B05 | 360 m (not the 520 m direct path) |
| B16 → B24 | B16 → B08 → B05 → B24 | 540 m |
| G1 → B30 | G1 → B11 → B08 → B09 → B25 → B30 | 820 m |
| G1 → MUH | none | "No route" |

---

## M5 · Wire up the five features 🔌
- [ ] **Navigation:** from/to → shortest path → pushed to history. "Back" pops it
- [ ] **Resource search:** find a room by ID (e.g. `B5-003`) with the hash table; browse labs or classrooms with the BST
- [ ] **Booking:** book a room. If it's full, join the waiting list. On a cancel, the next person is promoted automatically (test with **B5-003**, which starts full)
- [ ] **Scheduler:** load the courses → list the clashes
- [ ] **Search and sort:** sort rooms 3 ways; find a room with linear and with binary search
- [ ] Student requests go through the queue in order
- [ ] Bad input (letters for numbers, unknown IDs) never crashes the program

**✅ Done when:** a full demo run goes through every menu option with no crash.

---

## M6 · Testing 🧪
- [ ] Test table with 25+ cases: ID · feature · input · expected · actual · pass/fail
- [ ] Must-have cases:
  - [ ] the two detours above · no route to MUH · unknown ID `B99`
  - [ ] binary search for the first ID (`B19-100`), the last ID (`B5-010`) and a missing one (`B7-999`)
  - [ ] sorting data that is already sorted, reverse sorted and full of duplicates (lots of capacity-20 labs)
  - [ ] B5-003 full → waiting list → promoted on cancel
  - [ ] clashes: IT7011/IT8118, IT8118/IT8101, IT8108/IT8415 · touching times (IT7006 ends 10:00, IT7011 starts 10:00) are **not** a clash · a clean timetable of IT7006 + IT7009 + IT7005 has no clashes
- [ ] A screenshot of every run for the report

**✅ Done when:** the table is complete with screenshots.

---

## M7 · Complexity analysis 📈
- [ ] Big-O for time and space for every operation of every structure (best, average and worst)
- [ ] Algorithms: Dijkstra O((V+E) log V) · BFS/DFS O(V+E) · binary search O(log n) · linear search O(n) · merge sort O(n log n)
- [ ] Explain each one using your own code (loops, recursion depth, heap height)
- [ ] Worst cases: hash collisions, an unbalanced BST, a bad quick sort pivot
- [ ] ⭐ A+ extra: time with `System.nanoTime()` at n = 100, 1,000, 10,000 and 100,000. Compare linear vs binary search and hash vs list lookup in a table and a chart

---

## M8 · Report and submit 📦
- [ ] Report (.docx, 10–15 pages): cover → intro → design (map, UML, justification table) → data structures → algorithms → features with screenshots → testing → complexity → limitations (e.g. approximate distances) → conclusion → contribution table → references (cite polytechnic.bh for the building data)
- [ ] Javadoc, NetBeans Format, remove debug prints, Clean & Build with no errors
- [ ] A short AI-use note (which tools you used and for what)
- [ ] ZIP it as `StreamNo_LeaderID.zip`, then test unzipping and running it on another PC
- [ ] Upload to Moodle a day early, then re-download it to check

---

## 📁 Project layout
- `pom.xml`: NetBeans Maven project, JDK 17. Open this folder in NetBeans with **File → Open Project**
- `src/main/java/smartcampus/Main.java`: entry point (for now it prints a data summary)
- `model/`: the real-world classes (Building, Pathway, Room, Student, Course, TimeSlot, Request, Booking + enums)
- `service/DataLoader.java`: creates all the campus data in code
- `ds/`, `algo/`, `ui/`, `test/`: empty packages, ready for your code
- `docs/campus_map.png`: the campus graph for the report
