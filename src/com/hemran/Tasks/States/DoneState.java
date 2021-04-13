package com.hemran.Tasks.States;

import com.hemran.Tasks.Work;

public class DoneState implements WorkState {

    private final int MAX_SIZE = -1;

    @Override
    public void next(Work work) {
        System.out.println("List is already marked as done.");
    }

    @Override
    public void prev(Work work) {
        WorkState state = new InProgressState();
        work.setState(state);
        work.setMaxSize(state.getMaxSize());
    }

    @Override
    public int getMaxSize() {
        return MAX_SIZE;
    }

    @Override
    public String toString() {
        return "Done State";
    }

}
