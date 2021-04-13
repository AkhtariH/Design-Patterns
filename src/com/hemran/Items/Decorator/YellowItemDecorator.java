package com.hemran.Items.Decorator;

import com.hemran.Items.Item;

public class YellowItemDecorator extends ItemDecorator {

    public YellowItemDecorator(Item item) {
        super(item);
    }

    @Override
    public String getContent() {
        return this.highlight() + this.item.getContent() + "\u001B[0m";
    }

    @Override
    public String highlight() {
        return "\u001B[33m";
    }

}
