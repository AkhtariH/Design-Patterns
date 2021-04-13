package com.hemran.Items;

import java.awt.*;

public class ToDoItem implements Item {

    private String content;
    private Priority priority;
    private boolean checked;

    public ToDoItem(String content, Priority priority) {
        this.content = content;
        this.priority = priority;
        this.checked = false;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public Priority getPriority() {
        return priority;
    }

    @Override
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public boolean isChecked() { return this.checked; }

    @Override
    public void setChecked(boolean checked) { this.checked = checked; }

    @Override
    public String highlight() {
        return "\\u001B[37m";
    }

}
