package com.hemran.Tasks.Factory;

import com.hemran.Tasks.Task;

public interface TaskCreator {
    public Task createTask(String type, String name);
}
