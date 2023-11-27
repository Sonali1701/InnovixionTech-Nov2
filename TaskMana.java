import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskMana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Task> tasks = new ArrayList<>();

        while (true) {
            System.out.println("\nTask Manager Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask(tasks, scanner);
                    break;
                case 2:
                    listTasks(tasks);
                    break;
                case 3:
                    System.out.println("Exiting Task Manager. Have a great day!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addTask(List<Task> tasks, Scanner scanner) {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter due date (yyyy-MM-dd): ");
        LocalDate dueDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter priority (HIGH, MEDIUM, LOW): ");
        Priority priority = Priority.valueOf(scanner.nextLine().toUpperCase());

        Task task = new Task(description, dueDate, priority);
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    private static void listTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }

        System.out.println("\nAll Tasks:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}

class Task {
    private String description;
    private LocalDate dueDate;
    private Priority priority;
    private boolean completed;

    public Task(String description, LocalDate dueDate, Priority priority) {
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = false;
    }

    // Getters, setters, and other methods

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", priority=" + priority +
                ", completed=" + completed +
                '}';
    }
}

enum Priority {
    HIGH, MEDIUM, LOW
}
