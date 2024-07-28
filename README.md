**EXERCISE 1**

**DESIGN PATTERNS**

**BEHAVIORAL DESIGN PATTERNS:**

Observer Pattern

Use Case: A weather station system where multiple displays need to update in real-time as the weather station provides data.

Strategy Pattern

Use Case: A payment processing system that supports different payment methods like credit card, PayPal, and Bitcoin.


**CREATIONAL DESIGN PATTERNS:**

Singleton Pattern

Use Case: A logging system where a single instance of the logger is needed across the application.

Factory Method Pattern

Use Case: A simple document editor that can create different types of documents like Word, PDF, and Text.


**STRUCTURAL DESIGN PATTERNS:**

Adapter Pattern

Use Case: A media player application that can play different formats (MP3, MP4, VLC) using different players.

Composite Pattern

Use Case: A file system where directories can contain files and other directories.


**EXERCISE 2**

**VIRTUAL CLASSROOM MANAGER**

**OVERVIEW:**

The Virtual Classroom Manager is a command-line application designed to facilitate the management of virtual classrooms. It allows administrators to create classrooms, enroll students, schedule assignments, 
submit assignments, and manage resources specific to each class.

**FEATURES:**

Create Classrooms: Easily create and manage multiple classrooms.

Enroll Students: Add students to classrooms for easy access and tracking.

Schedule and Submit Assignments: Schedule assignments for classes and allow students to submit their work.

Resource Management: Add resources specific to each classroom, accessible only to enrolled students.

**COMMANDS USAGE:**

**1. Add Classroom**

Command: add_classroom <className>

Description: Creates a new classroom with the specified name.

Example: add_classroom csbs

**2. Add Student**

Command: add_student <studentId> <className>

Description: Enrolls a student in the specified classroom using the student's ID.

Example: add_student 21H033 csbs

**3. Schedule Assignment**

Command: schedule_assignment <className> <details>

Description: Schedules an assignment for the specified classroom with the given details.

Example: schedule_assignment csbs "Assignment 1: Leetcode questions"

**4. Submit Assignment**

Command: submit_assignment <studentId> <className> <details>

Description: Submits an assignment for a specific student in the specified classroom.

Example: submit_assignment 21H033 csbs "Submitted Assignment 1"

**5. Add Resource**

Command: add_resource <title> <description> <link> <className>

Description: Adds a resource to a specific classroom, including the title, description, and URL.

Example: add_resource "Stock Market Basics" "An article on stock market basics" "https://example.com/stock-market" csbs

**6. List Resources**

Command: list_resources <className>

Description: Lists all resources available for the specified classroom.

Example: list_resources csbs

**7. Exit Application**

Command: exit

Description: Exits the Virtual Classroom Manager application.
