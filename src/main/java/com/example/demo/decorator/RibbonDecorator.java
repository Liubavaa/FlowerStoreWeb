package com.example.demo.decorator;

import com.example.demo.flowers.Item;

public class RibbonDecorator extends ItemDecorator {
    public RibbonDecorator(Item item){
        super(item);
        setDescription(item.getDescription()+" decorated with ribbon");
    }
    @Override
    public double getPrice() {return item.getPrice()+40;}
}
