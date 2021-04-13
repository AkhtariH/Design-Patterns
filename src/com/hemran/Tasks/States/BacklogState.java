package com.hemran.Tasks.States;

import com.hemran.Tasks.Work;

public class BacklogState implements WorkState {

    private final int MAX_SIZE = 10;

    @Override
    public void next(Work work) {
        WorkState state = new InProgressState();
        work.setState(state);
        work.setMaxSize(state.getMaxSize());
    }

    @Override
    public void prev(Work work) {
        System.out.println("Already in the first state.");
    }

    @Override
    public int getMaxSize() {
        return MAX_SIZE;
    }

    @Override
    public String toString() {
        return "Backlog State";
    }


}
