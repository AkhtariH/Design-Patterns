package com.hemran.Tasks.States;

import com.hemran.Tasks.Work;

public class BacklogState implements WorkState {

    public void state(Work work) {
        System.out.println("Tasklist is in backlog state");
        work.setState(this);
    }

    @Override
    public void next(Work work) {
        work.set
    }

    @Override
    public void prev(Work work) {

    }

    @Override
    public String toString() {
        return "Backlog State";
    }

}
