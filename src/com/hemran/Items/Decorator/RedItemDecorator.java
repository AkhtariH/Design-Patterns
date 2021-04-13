package com.hemran.Items.Decorator;

import com.hemran.Items.Item;

public class RedItemDecorator extends ItemDecorator {

    public RedItemDecorator(Item item) {
        super(item);
    }

    @Override
    public String getContent() {
        return this.highlight() + super.getContent() + "\u001B[0m";
    }

    @Override
    public String highlight() {
        return "\u001B[31m";
    }

}
