package VirtualClassroomManager.src.main.java.virtualclassroommanager.utils;

public class InputValidator {

    public static boolean isValidCommand(String command) {
        if (command == null || command.trim().isEmpty()) {
            return false;
        }

        String[] parts = command.split(" ");
        if (parts.length == 0) {
            return false;
        }

        String action = parts[0].toLowerCase();
        switch (action) {
            case "add_classroom":
            case "add_student":
            case "schedule_assignment":
            case "submit_assignment":
                return parts.length > 1;
            case "add_resource":
                // Adjust to check for proper command structure
                return parts.length >= 2 && command.contains("\"");
            case "list_resources":
            case "list_classrooms":
            case "exit":
                return true;
            default:
                return false;
        }
    }
}