package com.hemran.Items.Decorator;

import com.hemran.Items.Item;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ItemReminderDecorator extends ItemDecorator {

    protected LocalDateTime time;

    public ItemReminderDecorator(Item item, String time) {
        super(item);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(time, formatter);
        this.time = dateTime;
    }

    @Override
    public String getContent() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        return super.getContent() + "\u001B[0m" + ", Reminder: " + getTime().format(formatter);
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
