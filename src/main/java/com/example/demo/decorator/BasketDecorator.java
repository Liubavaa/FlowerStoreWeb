package com.example.demo.decorator;

import com.example.demo.flowers.Item;

public class BasketDecorator extends ItemDecorator {
    public BasketDecorator(Item item){
        super(item);
        setDescription(item.getDescription()+" decorated with basket");
    }

    @Override
    public double getPrice() {return item.getPrice()+4;}
}
