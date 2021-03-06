package com.hemran;

import com.hemran.Date.DateFormat;
import com.hemran.Date.DateValidator;
import com.hemran.Items.Decorator.ItemColorDecorator;
import com.hemran.Items.Decorator.ItemPriorityDecorator;
import com.hemran.Items.Decorator.ItemReminderDecorator;
import com.hemran.Items.Item;
import com.hemran.Items.Priority;
import com.hemran.Items.ToDoItem;
import com.hemran.Tasks.Factory.TaskCreator;
import com.hemran.Tasks.Factory.TaskFactory;
import com.hemran.Tasks.Task;
import com.hemran.Tasks.Work;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Application {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    private Todo todo;
    private TaskCreator taskCreator;
    private Task currentTask;

    public void run() {
        todo = new Todo();
        taskCreator = new TaskFactory();
        clearScreen();
        mainMenu();
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void mainMenu() {
        System.out.println("---------------------------------------");
        System.out.println("Main Menu");
        System.out.println("---------------------------------------");

        int counter = 1;
        if (todo.size() > 0) {
            for(Task t : todo.getTasks()) {
                String state = (t instanceof Work ? " -- " + t.getState().toString() + " --" : "");
                System.out.println("[" + counter + "] " + t.getName() + " (" + t.getClass().getSimpleName() + ")" + state);
                counter++;
            }
        } else {
            System.out.println("No entries found.");
        }

        System.out.println("\n[" + counter + "] New list");
        System.out.print("Choose: ");
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();

        clearScreen();

        if (i <= todo.size()) {
            currentTask = todo.getTasks().get(i - 1);

            listView();
        } else if (i == todo.size() + 1) {
            addList();
        } else {
            System.out.println("Not a valid choice.");
            mainMenu();
        }

    }

    public void addList() {
        System.out.println("---------------------------------------");
        System.out.println("New list");
        System.out.println("---------------------------------------");
        System.out.print("Name for the list: ");

        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.print("What type of list (PRIVATE / WORK): ");
        Scanner in2 = new Scanner(System.in);
        String type = in2.nextLine();

        Task task = taskCreator.createTask(type.toUpperCase(), name);
        todo.addTask(task);
        clearScreen();
        mainMenu();
    }

    public void listView() {
        System.out.println("---------------------------------------");
        String state = (currentTask instanceof Work ? " -- " + currentTask.getState().toString() + " --" : "");
        System.out.println(currentTask.getName() + " (" + currentTask.getClass().getSimpleName() + ")" + state);
        System.out.println("---------------------------------------");

        if (currentTask.size() > 0) {
            for (Item it : currentTask.getItems()) {
                String check = it.isChecked() ? "X" : " ";
                System.out.println("[" + check + "] " + it.getContent());
            }
        } else {
            System.out.println("No entries found.");
        }

        String changeStateString = currentTask instanceof Work ? "[5] Change List State" : "";
        System.out.println("\n[1] Check/Uncheck Item");
        System.out.println("[2] New Item");
        System.out.println("[3] Edit Item");
        System.out.println("[4] Remove Item\n");
        System.out.println(changeStateString);
        System.out.println("[6] Delete List");
        System.out.println("\n[7] Main Menu");

        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();

        switch (choice) {
            case 1:
                checkItem();
                break;
            case 2:
                addItem();
                clearScreen();
                break;
            case 3:
                editItem();
                break;
            case 4:
                removeItem();
                break;
            case 5:
                changeState();
                break;
            case 6:
                deleteList();
                break;
            case 7:
                clearScreen();
                mainMenu();
                break;
        }
    }

    public void changeState() {
        System.out.println("---------------------------------------");
        System.out.println("Change List State");
        System.out.println("---------------------------------------");
        System.out.println("[1] Previous");
        System.out.println("[2] Next");

        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();

        if (choice == 1) {
            currentTask.previousState();
        } else if (choice == 2) {
            currentTask.nextState();
        } else {
            System.out.println("Not a valid choice.");
            changeState();
        }

        clearScreen();
        listView();
    }

    public void deleteList() {
        todo.removeTask(currentTask);
        clearScreen();
        mainMenu();
    }

    public void editItem() {
        System.out.println("---------------------------------------");
        System.out.println("Edit Item");
        System.out.println("---------------------------------------");
        System.out.print("Item Nr.: ");
        Scanner in = new Scanner(System.in);
        int nr = in.nextInt();

        if (nr <= currentTask.size() && nr >= 1) {
            System.out.print("Content: ");
            Scanner in2 = new Scanner(System.in);
            String content = in2.nextLine();

            System.out.print("Priority (LOW, MEDIUM, HIGH): ");
            Scanner in3 = new Scanner(System.in);
            String priority = in3.nextLine();
            Priority prio = null;
            if (priority.equalsIgnoreCase("low")) {
                prio = Priority.LOW;
            } else if (priority.equalsIgnoreCase("medium")) {
                prio = Priority.MEDIUM;
            } else if (priority.equalsIgnoreCase("high")) {
                prio = Priority.HIGH;
            } else {
                prio = Priority.MEDIUM;
            }

            System.out.print("Color (GREEN, YELLOW, RED) [Optional]: ");
            Scanner in4 = new Scanner(System.in);
            String color = in4.nextLine();



            Item item = null;
            switch(color.toUpperCase()) {
                case "GREEN":
                    item = new ItemPriorityDecorator(new ItemColorDecorator(currentTask.getItems().get(nr - 1), ANSI_GREEN), prio);
                    break;
                case "YELLOW":
                    item = new ItemPriorityDecorator(new ItemColorDecorator(currentTask.getItems().get(nr - 1), ANSI_YELLOW), prio);
                    break;
                case "RED":
                    item = new ItemPriorityDecorator(new ItemColorDecorator(currentTask.getItems().get(nr - 1), ANSI_RED), prio);
                    break;
                default:
                    item = new ItemPriorityDecorator(currentTask.getItems().get(nr - 1), prio);
            }

            String time = null;
            if (currentTask.getItems().get(nr - 1) instanceof ItemReminderDecorator) {
                System.out.println("Time (DD-MM-YYYY HH:MM): ");
                Scanner in5 = new Scanner(System.in);
                time = in5.nextLine();
            }

            item.setContent(content);
            item.setPriority(prio);

            if (currentTask.getItems().get(nr - 1) instanceof ItemReminderDecorator) {
                ((ItemReminderDecorator) currentTask.getItems().get(nr - 1)).setTime(time);
            }

            clearScreen();
            listView();
        } else {
            System.out.println("Not a valid choice.");
            removeItem();
        }
    }

    public void removeItem() {
        System.out.println("---------------------------------------");
        System.out.println("Remove Item");
        System.out.println("---------------------------------------");
        System.out.print("Item Nr.: ");
        Scanner in = new Scanner(System.in);
        int nr = in.nextInt();

        if (nr <= currentTask.size() && nr >= 1) {
            currentTask.removeItem(currentTask.getItems().get(nr - 1));
            clearScreen();
            listView();
        } else {
            System.out.println("Not a valid choice.");
            removeItem();
        }
    }

    public void checkItem() {
        System.out.println("---------------------------------------");
        System.out.println("Check/Uncheck Item");
        System.out.println("---------------------------------------");
        System.out.print("Item Nr.: ");
        Scanner in = new Scanner(System.in);
        int nr = in.nextInt();

        if (nr <= currentTask.size() && nr >= 1) {
            if (currentTask.getItems().get(nr - 1).isChecked()) {
                currentTask.getItems().get(nr - 1).setChecked(false);
            } else {
                currentTask.getItems().get(nr - 1).setChecked(true);
            }

            clearScreen();
            listView();
        } else {
            System.out.println("Not a valid choice.");
            checkItem();
        }
    }

    public void addItem() {
        System.out.println("---------------------------------------");
        System.out.println("New Item");
        System.out.println("---------------------------------------");
        System.out.println("Type: ");
        System.out.println("[1] Normal Item");
        System.out.println("[2] Reminder Item");

        Scanner in1 = new Scanner(System.in);
        int type = in1.nextInt();


        System.out.print("Content: ");
        Scanner in = new Scanner(System.in);
        String content = in.nextLine();

        System.out.print("Priority (LOW, MEDIUM, HIGH) [Optional]:");
        Scanner in2 = new Scanner(System.in);
        String priority = in2.nextLine();
        Priority prio = null;
        if (priority.equalsIgnoreCase("low")) {
            prio = Priority.LOW;
        } else if (priority.equalsIgnoreCase("medium")) {
            prio = Priority.MEDIUM;
        } else if (priority.equalsIgnoreCase("high")) {
            prio = Priority.HIGH;
        } else {
            prio = Priority.MEDIUM;
        }

        System.out.print("Color (GREEN, YELLOW, RED) [Optional]: ");
        Scanner in3 = new Scanner(System.in);
        String color = in3.nextLine();

        Item maskItem = new ToDoItem(content, prio);

        Item item = null;
        switch(color.toUpperCase()) {
            case "GREEN":
                item = new ItemPriorityDecorator(new ItemColorDecorator(maskItem, ANSI_GREEN), prio);
                break;
            case "YELLOW":
                item = new ItemPriorityDecorator(new ItemColorDecorator(maskItem, ANSI_YELLOW), prio);
                break;
            case "RED":
                item = new ItemPriorityDecorator(new ItemColorDecorator(maskItem, ANSI_RED), prio);
                break;
            default:
                item = new ItemPriorityDecorator(maskItem, prio);
        }

        if (type == 2) {
            System.out.println("Time (DD-MM-YYYY HH:MM): ");
            Scanner in5 = new Scanner(System.in);
            String time = in5.nextLine();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy h:m");
            DateValidator validator = new DateFormat(dateFormatter);

            if (!validator.isValid(time)) {
                time = "01-01-2021 00:00";
            }

            item = new ItemReminderDecorator(item, time);
        }

        currentTask.addItem(item);

        clearScreen();
        listView();
    }
}
