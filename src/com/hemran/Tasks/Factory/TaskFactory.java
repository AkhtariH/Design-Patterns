package com.hemran.Tasks.Factory;

import com.hemran.Tasks.Private;
import com.hemran.Tasks.Task;
import com.hemran.Tasks.Work;

public class TaskFactory implements TaskCreator {

    @Override
    public Task createTask(String type, String name) {
        if(type == null){
            return null;
        }

        if(type.equalsIgnoreCase("PRIVATE")){
            return new Private(name);

        } else if(type.equalsIgnoreCase("WORK")){
            return new Work(name);

        }

        return null;
    }
}
