package com.hemran.Tasks;

import com.hemran.Items.Item;
import com.hemran.Tasks.States.WorkState;

import java.util.ArrayList;

public interface Task{

    String getName();

    void addItem(Item i);

    void removeItem(Item i);

    int size();

    ArrayList<Item> getItems();

    WorkState getState();

    void setState(WorkState state);

    void previousState();

    void nextState();

    void setMaxSize(int size);

}
