package VirtualClassroomManager.src.main.java.virtualclassroommanager.models;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private String name;
    private List<Student> students = new ArrayList<>();
    private List<Assignment> assignments = new ArrayList<>();

    public Classroom(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    public void submitAssignment(String studentId, String details) {
        // For simplicity, we just record the submission details.
        System.out.println("Recording submission for " + studentId + ": " + details);
    }

    // Method to check if a student is enrolled in the classroom
    public boolean isStudentEnrolled(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return true;
            }
        }
        return false;
    }
}
