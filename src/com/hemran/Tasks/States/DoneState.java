package com.hemran.Tasks.States;

import com.hemran.Tasks.Work;

public class DoneState implements WorkState {

    private final Rights[] RIGHTS = {};

    @Override
    public void next(Work work) {
        System.out.println("List is already marked as done.");
    }

    @Override
    public void prev(Work work) {
        WorkState state = new InProgressState();
        work.setState(state);
        work.setRights(state.getRights());
    }

    @Override
    public Rights[] getRights() {
        return this.RIGHTS;
    }

    @Override
    public String toString() {
        return "Done State";
    }

}
