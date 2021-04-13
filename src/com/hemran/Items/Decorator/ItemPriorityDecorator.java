package com.hemran.Items.Decorator;

import com.hemran.Items.Item;
import com.hemran.Items.Priority;

public class ItemPriorityDecorator extends ItemDecorator {

    protected Priority priority;

    public ItemPriorityDecorator(Item item, Priority priority) {
        super(item);
        this.priority = priority;
    }

    @Override
    public String getContent() {
        return super.getContent() + displayPriority();
    }

    public String displayPriority() {
        return ", Priority: " + this.priority;
    }
}
