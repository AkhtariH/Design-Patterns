package com.hemran.Tasks.States;

import com.hemran.Tasks.Work;

public class BacklogState implements WorkState {

    public void state(Work work) {
        System.out.println("Tasklist is in backlog state");
        work.setState(this);
    }

    public String toString() {
        return "Backlog State";
    }

}
