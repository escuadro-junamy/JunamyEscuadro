import java.util.Scanner; // Importing Scanner class for reading user input

// Class to represent a task with description, priority, and completion status
class Task {
    String description;  // Description of the task
    String priority;     // Priority of the task (High, Medium, Low)
    boolean isCompleted; // Boolean flag to mark task completion

    // Constructor to initialize the task with description and priority
    Task(String description, String priority) {
        this.description = description;
        this.priority = priority;
        this.isCompleted = false; // Task is initially not completed
    }
}

// Main class for the To-Do List application
public class ToDoListApp {
    private static final int MAX_TASKS = 6; // Maximum number of tasks
    private static Task[] tasks = new Task[MAX_TASKS]; // Array to store tasks
    private static int taskCount = 0; // Counter to keep track of the number of tasks

    // Main method to run the application
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for reading user input

        // Infinite loop to display the menu and handle user choices
        while (true) {
            System.out.println("\nMain Menu:"); // Display menu
            System.out.println("1. Add a new task"); // Option to add a new task
            System.out.println("2. Mark a task as complete"); // Option to mark a task as complete
            System.out.println("3. View all tasks"); // Option to view all tasks
            System.out.println("4. Exit"); // Option to exit the application
            System.out.print("Choose an option: "); // Prompt user for choice
            int choice = scanner.nextInt(); // Read user's choice
            scanner.nextLine();  // Consume newline left by nextInt()

            // Switch case to handle the user's choice
            switch (choice) {
                case 1:
                    addTask(scanner); // Call method to add a new task
                    break;
                case 2:
                    markTaskComplete(scanner); // Call method to mark a task as complete
                    break;
                case 3:
                    viewTasks(); // Call method to view all tasks
                    break;
                case 4:
                    System.out.println("Exiting..."); // Print exit message
                    scanner.close(); // Close the scanner to release resources
                    return; // Exit the application
                default:
                    System.out.println("Invalid choice. Please try again."); // Handle invalid choices
            }
        }
    }

    // Method to add a new task
    private static void addTask(Scanner scanner) {
        if (taskCount >= MAX_TASKS) { // Check if the task list is full
            System.out.println("Task list is full."); // Inform the user
            return; // Exit the method
        }
        System.out.print("Enter task description: "); // Prompt user for task description
        String description = scanner.nextLine(); // Read task description
        System.out.print("Enter task priority (High/Medium/Low): "); // Prompt user for task priority
        String priority = scanner.nextLine(); // Read task priority

        // Validate the priority input
        if (!(priority.equalsIgnoreCase("High") ||
                priority.equalsIgnoreCase("Medium") ||
                priority.equalsIgnoreCase("Low"))) {
            System.out.println("Invalid priority. Task not added."); // Inform user of invalid priority
            return; // Exit the method
        }

        tasks[taskCount] = new Task(description, priority); // Create a new task and add it to the array
        taskCount++; // Increment the task counter
        System.out.println("Task added successfully."); // Inform user of successful task addition
    }

    // Method to mark a task as complete
    private static void markTaskComplete(Scanner scanner) {
        System.out.print("Enter task index to mark complete: "); // Prompt user for task index
        int index = scanner.nextInt(); // Read task index
        scanner.nextLine();  // Consume newline left by nextInt()

        if (index < 1 || index >= taskCount) { // Validate the task index
            System.out.println("Invalid task index."); // Inform user of invalid index
            return; // Exit the method
        }

        tasks[index].isCompleted = true; // Mark the task as complete
        System.out.println("Task marked as complete."); // Inform user
    }

    // Method to view all tasks
    private static void viewTasks() {
        if (taskCount == 1) { // Check if there are no tasks
            System.out.println("No tasks available."); // Inform user
            return; // Exit the method
        }

        // Iterate through the tasks and display their details
        for (int i = 1; i < taskCount; i++) { // Start from 1 due to the invalid first index in task array
            Task task = tasks[i]; // Get the task from the array
            System.out.printf("Task %d: %s [Priority: %s] - %s\n",
                    i, task.description, task.priority,
                    task.isCompleted ? "Completed" : "Incomplete"); // Display task details
        }
    }
}
