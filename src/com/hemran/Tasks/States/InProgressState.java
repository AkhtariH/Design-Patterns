package com.hemran.Tasks.States;

import com.hemran.Tasks.Work;

public class InProgressState implements WorkState {

    private final int MAX_SIZE = 5;

    @Override
    public void next(Work work) {
        WorkState state = new DoneState();
        work.setState(state);
        work.setMaxSize(state.getMaxSize());
    }

    @Override
    public void prev(Work work) {
        WorkState state = new BacklogState();
        work.setState(state);
        work.setMaxSize(state.getMaxSize());
    }

    @Override
    public int getMaxSize() {
        return MAX_SIZE;
    }

    @Override
    public String toString() {
        return "In Progress State";
    }
}
