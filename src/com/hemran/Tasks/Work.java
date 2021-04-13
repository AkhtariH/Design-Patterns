package com.hemran.Tasks;

import com.hemran.Tasks.States.BacklogState;
import com.hemran.Tasks.States.WorkState;

public class Work extends AbstractTask {

    private WorkState state;

    public Work(String name){
        super(name);
        this.state = new BacklogState();
    }

    @Override
    public WorkState getState() {
        return state;
    }

    @Override
    public void setState(WorkState state) { this.state = state; }

    @Override
    public void previousState() {
        state.prev(this);
    }

    @Override
    public void nextState() {
        state.next(this);
    }

}
