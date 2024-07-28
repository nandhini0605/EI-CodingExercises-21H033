package VirtualClassroomManager.src.main.java.virtualclassroommanager;

import VirtualClassroomManager.src.main.java.virtualclassroommanager.utils.InputValidator;
import VirtualClassroomManager.src.main.java.virtualclassroommanager.utils.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        ClassroomManager manager = new ClassroomManager();
        Scanner scanner = new Scanner(System.in);
        String command;
        boolean running = true;
        
        Logger.log("Virtual Classroom Manager Started");
        System.out.println("Enter the commands:");

        while (running) {
            System.out.print("> ");
            command = scanner.nextLine().trim();
            Logger.log("Received command: " + command);

            if (command.equalsIgnoreCase("exit")) {
                Logger.log("Exiting Virtual Classroom Manager.");
                running = false;
                break;
            }

            if (InputValidator.isValidCommand(command)) {
                String[] parts = splitCommand(command);
                String action = parts[0];

                try {
                    switch (action) {
                        case "add_classroom":
                            if (parts.length > 1 && parts[1] != null) {
                                manager.addClassroom(parts[1]);
                            } else {
                                System.out.println("Invalid command. Missing classroom name.");
                            }
                            break;
                        case "add_student":
                            if (parts.length > 2 && parts[1] != null && parts[2] != null) {
                                manager.enrollStudent(parts[1], parts[2]);
                            } else {
                                System.out.println("Invalid command. Usage: add_student <studentId> <className>");
                            }
                            break;
                        case "schedule_assignment":
                            if (parts.length > 2 && parts[1] != null && parts[2] != null) {
                                manager.scheduleAssignment(parts[1], parts[2]);
                            } else {
                                System.out.println("Invalid command. Usage: schedule_assignment <className> <details>");
                            }
                            break;
                        case "submit_assignment":
                            if (parts.length > 3 && parts[1] != null && parts[2] != null && parts[3] != null) {
                                manager.submitAssignment(parts[1], parts[2], parts[3]);
                            } else {
                                System.out.println("Invalid command. Usage: submit_assignment <studentId> <className> <details>");
                            }
                            break;
                        case "add_resource":
                            if (parts.length > 4 && parts[1] != null && parts[2] != null && parts[3] != null && parts[4] != null) {
                                manager.addResource(parts[1], parts[2], parts[3], parts[4]);
                            } else {
                                System.out.println("Invalid command. Usage: add_resource <title> <description> <link> <className>");
                            }
                            break;
                        
                        case "list_resources":
                            if (parts.length > 1 && parts[1] != null) {
                                manager.listResources(parts[1]);
                            } else {
                                System.out.println("Invalid command. Usage: list_resources <className>");
                            }
                            break;
                        default:
                            System.out.println("Invalid command. Please try again.");
                    }
                } catch (Exception e) {
                    Logger.log("Error: " + e.getMessage());
                    System.out.println("An error occurred: " + e.getMessage());
                }
            } else {
                System.out.println("Invalid command format. Please try again.");
            }
        }
        scanner.close();
    }

private static String[] splitCommand(String command) {
    List<String> result = new ArrayList<>();
    Matcher matcher = Pattern.compile("([^\"]\\S*|\"[^\"]*\")\\s*").matcher(command);
    while (matcher.find()) {
        result.add(matcher.group(1).replace("\"", ""));  
    }
    return result.toArray(new String[0]);
}

}
