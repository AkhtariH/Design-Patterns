package com.hemran.Items.Decorator;

import com.hemran.Items.Item;
import com.hemran.Items.Priority;

public abstract class ItemDecorator implements Item {

    protected Item item;

    public ItemDecorator(Item item) {
        this.item = item;
    }

    @Override
    public String getContent() {
        return this.item.getContent();
    }

    @Override
    public void setContent(String content) {
        this.item.setContent(content);
    }

    @Override
    public Priority getPriority() {
        return this.item.getPriority();
    }

    @Override
    public void setPriority(Priority priority) {
        this.item.setPriority(priority);
    }

    @Override
    public boolean isChecked() { return this.item.isChecked(); }

    @Override
    public void setChecked(boolean checked) { this.item.setChecked(checked); }

    @Override
    public String highlight() {
        return "\\u001B[37m";
    }

}
