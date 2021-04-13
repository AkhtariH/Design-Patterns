package com.hemran.Tasks;

import com.hemran.Items.Item;
import com.hemran.Tasks.States.WorkState;

import java.util.ArrayList;

public interface Task{

    public String getName();

    public void setName(String name);

    public void addItem(Item i);

    public void removeItem(Item i);

    public int size();

    public ArrayList<Item> getItems();

    public WorkState getState();

    public void setState(WorkState state);

}
