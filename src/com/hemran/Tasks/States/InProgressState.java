package com.hemran.Tasks.States;

import com.hemran.Tasks.Work;

public class InProgressState implements WorkState {

    @Override
    public void state(Work work) {
        System.out.println("Tasklist is in progress state");
        work.setState(this);
    }

    public String toString() {
        return "In Progress State";
    }
}
