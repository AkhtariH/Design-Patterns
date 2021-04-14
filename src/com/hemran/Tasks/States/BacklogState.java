package com.hemran.Tasks.States;

import com.hemran.Tasks.Work;

public class BacklogState implements WorkState {

    private final Rights[] RIGHTS = { Rights.ADD, Rights.DELETE };

    @Override
    public void next(Work work) {
        WorkState state = new InProgressState();
        work.setState(state);
        work.setRights(state.getRights());
    }

    @Override
    public void prev(Work work) {
        System.out.println("Already in the first state.");
    }

    @Override
    public Rights[] getRights() {
        return this.RIGHTS;
    }

    @Override
    public String toString() {
        return "Backlog State";
    }


}
