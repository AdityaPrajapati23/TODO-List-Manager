import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListManager {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        
        System.out.println("===== To-Do List Manager =====");
        
        while (running) {
            displayMenu();
            int choice = getUserChoice();
            
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    listTasks();
                    break;
                case 4:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1. Add a task");
        System.out.println("2. Remove a task");
        System.out.println("3. List all tasks");
        System.out.println("4. Exit");
        System.out.print("Enter your choice (1-4): ");
    }
    
    private static int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private static void addTask() {
        System.out.print("Enter the task to add: ");
        String task = scanner.nextLine().trim();
        
        if (!task.isEmpty()) {
            tasks.add(task);
            System.out.println("Task added successfully!");
        } else {
            System.out.println("Task cannot be empty.");
        }
    }
    
    private static void removeTask() {
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks to remove.");
            return;
        }
        
        listTasks();
        System.out.print("Enter the task number to remove: ");
        
        try {
            int taskNumber = Integer.parseInt(scanner.nextLine());
            
            if (taskNumber > 0 && taskNumber <= tasks.size()) {
                String removedTask = tasks.remove(taskNumber - 1);
                System.out.println("Removed task: " + removedTask);
            } else {
                System.out.println("Invalid task number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }
    
    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Your to-do list is empty.");
        } else {
            System.out.println("\n===== Your To-Do List =====");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
            System.out.println("===========================");
        }
    }
}