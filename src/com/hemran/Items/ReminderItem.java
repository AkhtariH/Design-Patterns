package com.hemran.Items;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReminderItem implements Item {

    private String content;
    private Priority priority;
    private LocalDateTime time;
    private boolean checked;

    public ReminderItem(String content, String time, Priority priority) {
        this.content = content;
        this.priority = priority;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(time, formatter);
        this.time = dateTime;
        this.checked = false;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public Priority getPriority() {
        return this.priority;
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

    public LocalDateTime getTime() {
        return this.time;
    }

    public void setTime(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(time, formatter);
        this.time = dateTime;
    }

}
