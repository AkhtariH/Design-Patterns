package com.hemran.Tasks.States;

import com.hemran.Tasks.Work;

public class InProgressState implements WorkState {

    private final Rights[] RIGHTS = { Rights.ADD };

    @Override
    public void next(Work work) {
        WorkState state = new DoneState();
        work.setState(state);
        work.setRights(state.getRights());
    }

    @Override
    public void prev(Work work) {
        WorkState state = new BacklogState();
        work.setState(state);
        work.setRights(state.getRights());
    }

    @Override
    public Rights[] getRights() {
        return this.RIGHTS;
    }

    @Override
    public String toString() {
        return "In Progress State";
    }
}
