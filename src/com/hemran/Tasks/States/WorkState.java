package com.hemran.Tasks.States;

import com.hemran.Tasks.Work;

public interface WorkState {
    void next(Work work);
    void prev(Work work);
    Rights[] getRights();
    String toString();
}
