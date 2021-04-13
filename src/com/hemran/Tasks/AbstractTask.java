package com.hemran.Tasks;

import com.hemran.Items.Item;
import com.hemran.Tasks.States.WorkState;

import java.util.ArrayList;

public abstract class AbstractTask implements Task {

    private String name;
    private ArrayList<Item> itemList;
    private int maxSize = 20;

    public AbstractTask(String name) {
        this.name = name;
        this.itemList = new ArrayList<Item>();
    }

    @Override
    public int size() { return this.itemList.size(); }

    @Override
    public void setMaxSize(int size) { this.maxSize = size; }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addItem(Item i) {
        if (size() < maxSize || maxSize == -1) {
            i.highlight();
            this.itemList.add(i);
        } else {
            System.out.println("List is full!");
        }
    }

    @Override
    public void removeItem(Item i) {
        this.itemList.remove(i);
    }

    @Override
    public ArrayList<Item> getItems() {
        return itemList;
    }

    @Override
    public WorkState getState() {
        return null;
    }

    @Override
    public void setState(WorkState state) {}

    @Override
    public void previousState() {}

    @Override
    public void nextState() {}

}
