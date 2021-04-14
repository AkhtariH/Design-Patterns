package com.hemran.Tasks;

import com.hemran.Items.Item;
import com.hemran.Tasks.States.BacklogState;
import com.hemran.Tasks.States.Rights;
import com.hemran.Tasks.States.WorkState;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Work extends AbstractTask {

    private WorkState state;
    private Rights[] rights;

    public Work(String name){
        super(name);
        this.state = new BacklogState();
        this.rights = new Rights[]{ Rights.ADD, Rights.DELETE };
    }

    @Override
    public void addItem(Item i) {
        boolean contains = Arrays.stream(this.rights).anyMatch(Rights.ADD::equals);
        if (contains) {
            i.highlight();
            super.getItems().add(i);
        } else {
            System.out.println("This state does not allow you to add an additional item.");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void removeItem(Item i) {
        boolean contains = Arrays.stream(this.rights).anyMatch(Rights.DELETE::equals);
        if (contains) {
            super.getItems().remove(i);
        } else {
            System.out.println("This state does not allow you to remove an item.");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setRights(Rights[] rights) {
        this.rights = rights;
    }

    @Override
    public WorkState getState() {
        return state;
    }

    @Override
    public void setState(WorkState state) { this.state = state; }

    @Override
    public void previousState() {
        state.prev(this);
    }

    @Override
    public void nextState() {
        state.next(this);
    }

}
