package com.hemran.Tasks.States;

import com.hemran.Tasks.Work;

public class DoneState implements WorkState {

    public void state(Work work) {
        System.out.println("Tasklist is in done state");
        work.setState(this);
    }

    public String toString() {
        return "Done State";
    }

}
