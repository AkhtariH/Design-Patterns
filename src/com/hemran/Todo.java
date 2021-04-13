package com.hemran;

import com.hemran.Tasks.Task;

import java.util.ArrayList;
import java.util.Iterator;

public class Todo {
    private ArrayList<Task> taskList;

    public Todo() {
        this.taskList = new ArrayList<Task>();
    }

    public void addTask(Task task) {
        this.taskList.add(task);
    }

    public void removeTask(Task task) {
        this.taskList.remove(task);
    }

    public ArrayList<Task> getTasks() {
        return this.taskList;
    }

    public int size() { return this.taskList.size(); }

    public String toString() {
        Iterator<Task> it = this.taskList.iterator();
        String list = "";
        int counter = 1;
        if (it.hasNext()) {
            Task next = it.next();
           list += "[" + counter + "] " + next.getName() + " (" + next.getClass().getSimpleName() + ")";
           counter++;
        }
        while (it.hasNext()) {
            Task next = it.next();
            list += ", " + "[" + counter + "] " + next.getName() + " (" + next.getClass().getSimpleName() + ")";
            counter++;
        }

        return list;
    }

}
