package com.example.demo.decorator;

import com.example.demo.flowers.Item;


public abstract class ItemDecorator extends Item {
    protected Item item;

    public ItemDecorator(Item item) {
        this.item = item;
    }
}
