package VirtualClassroomManager.src.main.java.virtualclassroommanager;

import VirtualClassroomManager.src.main.java.virtualclassroommanager.models.Classroom;
import VirtualClassroomManager.src.main.java.virtualclassroommanager.models.Student;
import VirtualClassroomManager.src.main.java.virtualclassroommanager.models.Assignment;
import VirtualClassroomManager.src.main.java.virtualclassroommanager.models.Resource;
import VirtualClassroomManager.src.main.java.virtualclassroommanager.utils.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassroomManager {
    private List<Classroom> classrooms = new ArrayList<>();
    private Map<String, Student> students = new HashMap<>();
    private List<Resource> resources = new ArrayList<>();

    public void addClassroom(String name) {
        if (findClassroom(name) == null) {
            classrooms.add(new Classroom(name));
            Logger.log("Classroom " + name + " created.");
            System.out.println("Classroom " + name + " has been created.");
        } else {
            Logger.log("Failed to create classroom: " + name + " already exists.");
            System.out.println("Classroom " + name + " already exists.");
        }
    }

    public void enrollStudent(String studentId, String className) {
        Classroom classroom = findClassroom(className);
        if (classroom != null) {
            Student student = students.computeIfAbsent(studentId, Student::new);
            classroom.addStudent(student);
            Logger.log("Student " + studentId + " enrolled in " + className);
            System.out.println("Student " + studentId + " has been enrolled in " + className + ".");
        } else {
            Logger.log("Classroom " + className + " not found.");
            System.out.println("Classroom " + className + " not found.");
        }
    }

    public void scheduleAssignment(String className, String details) {
        Classroom classroom = findClassroom(className);
        if (classroom != null) {
            classroom.addAssignment(new Assignment(details));
            Logger.log("Assignment scheduled for " + className);
            System.out.println("Assignment for " + className + " has been scheduled.");
        } else {
            Logger.log("Classroom " + className + " not found.");
            System.out.println("Classroom " + className + " not found.");
        }
    }

    public void submitAssignment(String studentId, String className, String details) {
        Classroom classroom = findClassroom(className);
        if (classroom != null) {
            if (classroom.isStudentEnrolled(studentId)) {
                classroom.submitAssignment(studentId, details);
                Logger.log("Assignment submitted by Student " + studentId + " in " + className);
                System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
            } else {
                Logger.log("Error: Student " + studentId + " is not enrolled in " + className + ".");
                System.out.println("Error: Student " + studentId + " is not enrolled in " + className + ".");
            }
        } else {
            Logger.log("Error: Classroom " + className + " does not exist.");
            System.out.println("Error: Classroom " + className + " does not exist.");
        }
    }

    public void addResource(String title, String description, String url, String className) {
        if (findClassroom(className) != null) {
            Resource resource = new Resource(title, description, url, className);
            resources.add(resource);
            Logger.log("Resource added to class " + className + ": " + title);
            System.out.println("Resource added to class " + className + ": " + title);
        } else {
            System.out.println("Class " + className + " does not exist.");
        }
    }
    

    public void listResources(String className) {
        if (className != null) {
            System.out.println("Resources for class " + className + ":");
            resources.stream()
                     .filter(resource -> resource.getClassName().equals(className))
                     .forEach(resource -> {
                         System.out.println(resource);
                         System.out.println("-----------------------------");
                     });
        } 
    }
    

    private Classroom findClassroom(String name) {
        return classrooms.stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
    }

}
