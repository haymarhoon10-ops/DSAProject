# 🧭 Smart Campus Navigation & Resource Management — A+ Milestones

**IT7011 · Java (NetBeans) · Group of 3–5**
Rubric: System Design 20% · Data Structures 25% · Algorithms 25% · Complexity Analysis 20% · Documentation 10%

> **Submission rules:** leader submits on Moodle · ONE **ZIP** (RAR = 0) named `StreamNo_LeaderID` (e.g. `01_202312345`) · Java files + **.docx** report (10–15 pages) with a cover page listing every member's full name and ID.
> **Not in the brief, so ask on day 1:** deadline and late penalty · GenAI policy · whether built-in `HashMap`/`PriorityQueue`/`TreeMap` are allowed (writing your own is the safe A+ choice) · console menu vs GUI.

Each milestone builds on the one before. Don't start the next one until the current one meets its **Done when** criteria.

---

## M1 · Lock the scope and the campus 🗺️
*Sets up System Design (20%)*

- [ ] Confirm the Smart Campus topic (an alternative needs the coordinator's approval)
- [ ] Ask the questions above and write the answers down
- [ ] **Design the campus:** 12–15 buildings, 20+ weighted pathways. Draw it, with distances on each edge
  - [ ] Include one route where the **direct edge is longer than a detour** (to show Dijkstra beats a greedy route)
  - [ ] Include one **isolated building** (for the "no route" edge case)
  - [ ] Decide directed or undirected, and write down why
- [ ] **Design the resource list:** 30+ rooms (classrooms, labs, study rooms) with ID, building, type, capacity, availability and popularity
- [ ] **Design the course timetable:** about 8 courses with day and time slots. Make sure at least 2 clash
- [ ] Create the NetBeans project, shared repo, package layout (`model`, `ds`, `algo`, `service`, `ui`, `test`) and JDK version

**✅ Done when:** the campus map drawing, room table and timetable are final, and every member can build the empty project.

---

## M2 · Design before code 📐
*System Design (20%)*

- [ ] UML class diagram: `Building`, `Pathway`, `Room`, `Booking`, `Student`, `Course`, `Request` + every data structure class + services
- [ ] Architecture diagram: UI → Services → Data structures/Algorithms → Data loader
- [ ] **Structure → feature justification table.** For each one, say why it fits and what you rejected:

| Feature | Structure | Key justification to write up |
|---|---|---|
| Resource storage | Hash table | O(1) average lookup by room ID vs O(n) list scan |
| Booking queue | Priority queue / heap | Highest-priority request served first, O(log n) insert/extract |
| Navigation map | Graph (adjacency list) | Campus is sparse → list beats O(V²) matrix |
| Navigation history | Stack | "Back" = last visited first (LIFO) |
| Student requests | Queue | Fair first-come-first-served (FIFO) |
| Resource categories | BST | Sorted browsing via in-order traversal |

- [ ] Define the **booking priority rule** (e.g. exam > lecture > study group, ties broken by request time)
- [ ] Sketch the main menu: one option per feature, plus Back/History and Exit

**✅ Done when:** someone outside the team could implement it from your diagrams alone.

---

## M3 · Build the six data structures 🧱
*Data Structure Implementation (25%)*

- [ ] **HashTable<K,V>:** hash function, collision handling (chaining), put/get/remove, resize
- [ ] **MinHeap / PriorityQueue:** insert, extractMin, peek, siftUp/siftDown (Dijkstra reuses this)
- [ ] **Graph:** addBuilding, addPathway, neighbours (adjacency list)
- [ ] **Stack:** push/pop/peek/isEmpty for navigation history
- [ ] **Queue** (linked list based): enqueue/dequeue for student requests
- [ ] **BST:** insert, search, in-order traversal for room categories
- [ ] **DataLoader:** fills every structure from the M1 data at startup
- [ ] Small `main` or JUnit check for each structure, including the empty case and a single element

**✅ Done when:** all six pass their own tests on their own, before any feature uses them.

---

## M4 · Build the algorithms ⚙️
*Algorithm Implementation (25%)*

- [ ] **Dijkstra** using your heap. Returns the **full path + total distance**. Handles same start/end, unreachable and unknown buildings
- [ ] **BFS:** route with the fewest stops, or buildings within N hops
- [ ] **DFS:** timetable conflict detection on a course conflict graph (and/or a connectivity check)
- [ ] **Merge sort or quick sort** with a comparator: by capacity, availability or popularity
- [ ] **Binary search** on the sorted list, plus **linear search** on the unsorted list (the brief asks for both)

**✅ Done when:** your Dijkstra result for 3 building pairs matches a hand calculation on the M1 map.

---

## M5 · Wire up the five features 🔌
*Shows off DS + Algorithms working together*

- [ ] **Navigation:** pick from/to → shortest path printed → pushed to history; "Back" pops it
- [ ] **Resource search:** look up a room by ID through the hash table; browse a category through the BST
- [ ] **Booking:** book a room → if full, join the **waiting list** → when someone cancels, the next person is **promoted automatically**
- [ ] **Scheduler:** add courses → conflicts detected and listed
- [ ] **Search & sort:** sort rooms 3 ways; find a room with linear and with binary search
- [ ] Student requests go through the queue and are processed in order
- [ ] Bad input (letters for numbers, unknown IDs) never crashes the program

**✅ Done when:** a full demo run goes through every menu option with no crash.

---

## M6 · Test it and prove it 🧪
*Deliverable: Test Cases and Results*

- [ ] Test table: ID · feature · input · expected · actual · pass/fail. Aim for 25 or more cases
- [ ] For each feature, cover normal, edge and invalid input
- [ ] Must-have cases:
  - [ ] the detour beats the direct edge
  - [ ] no route to the isolated building
  - [ ] binary search on the first, last and a missing item
  - [ ] sorting data that is already sorted, reverse sorted and has duplicates
  - [ ] a full room going to the waiting list and then being promoted
  - [ ] a timetable clash and a clean timetable
- [ ] Screenshot every test run for the report
- [ ] Fix bugs and re-run until all pass (or note any known issue honestly)

**✅ Done when:** the test table is complete and has a screenshot for every case.

---

## M7 · Complexity analysis 📈
*Complexity Analysis (20%), which is easy marks if done properly*

- [ ] Time + space Big-O table for **every operation of every structure** (best / average / worst)
- [ ] Big-O for every algorithm: Dijkstra **O((V+E) log V)**, BFS/DFS **O(V+E)**, binary search **O(log n)**, linear search **O(n)**, merge sort **O(n log n)** (or quick sort's O(n²) worst case)
- [ ] Explain *why* each one holds, using **your own code** (loops, recursion depth, heap height)
- [ ] Discuss the worst cases: hash collisions, an unbalanced BST, a bad quick sort pivot
- [ ] ⭐ **A+ extra:** time operations at n = 100, 1,000, 10,000 and 100,000 with `System.nanoTime()`, then compare linear vs binary search and hash vs list lookup in a table and chart

**✅ Done when:** every class and algorithm in the code has an entry in the table and an explanation.

---

## M8 · Report and submit 📦
*Documentation (10%), plus it presents the other 90%*

- [ ] **Report (.docx, 10–15 pages):** cover page (all names + IDs) → introduction and problem → design (M2) → data structures (M3) → algorithms (M4) → features with screenshots (M5) → testing (M6) → complexity (M7) → challenges, limitations and improvements → conclusion → contribution table → references
- [ ] Code polish: Javadoc on all classes and public methods, NetBeans *Format*, remove debug prints, **Clean & Build** with no errors
- [ ] Cite any sources you used
- [ ] ZIP the NetBeans project + .docx → **`StreamNo_LeaderID.zip`** (not RAR)
- [ ] Test the ZIP: unzip it on another PC, open it in NetBeans and run it
- [ ] Leader uploads to Moodle a day early, then re-downloads to check it

**✅ Done when:** Moodle shows the submission and the re-downloaded ZIP runs.

---

## 📅 Timeline (fill in once you know the deadline)
| Milestone | Target date | Owner | Status |
|---|---|---|---|
| M1 Scope + campus data | | All | |
| M2 Design | | Leader | |
| M3 Data structures | | Split by structure | |
| M4 Algorithms | | Graph owner + sort/search owner | |
| M5 Features | | Leader integrates | |
| M6 Testing | | Tester + each owner | |
| M7 Complexity | | Each owner for their code | |
| M8 Report + submit | | All → Leader submits | |

**Rough guide:** if you have about 5 weeks, do M1–M2 in week 1, M3 in week 2, M4–M5 in week 3, M6–M7 in week 4 and M8 in week 5.

## 👥 Suggested ownership
- **Leader:** design, integration and menu, report assembly, submission
- **Navigation:** graph, Dijkstra, BFS/DFS, stack, scheduler
- **Resources:** hash table, BST, sorting and searching
- **Bookings:** heap, queue, booking with waiting list
- **5th member (if any):** testing and timing experiments
- Each owner writes the report and complexity sections for their own code
# DSAProject