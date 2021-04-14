package com.hemran.Items.Decorator;

import com.hemran.Items.Item;

public class ItemColorDecorator extends ItemDecorator {

    protected String color;

    public ItemColorDecorator(Item item, String color) {
        super(item);
        this.color = color;
    }

    @Override
    public String getContent() {
        return highlight() + super.getContent() + "\u001B[0m";
    }

    @Override
    public String highlight() {
        return this.color;
    }

}
