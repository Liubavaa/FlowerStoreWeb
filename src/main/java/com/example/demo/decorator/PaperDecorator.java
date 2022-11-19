package com.example.demo.decorator;

import com.example.demo.flowers.Item;

public class PaperDecorator extends ItemDecorator {
    public PaperDecorator(Item item){
        super(item);
        setDescription(item.getDescription()+" decorated with paper");
    }

    @Override
    public double getPrice() {return item.getPrice()+13;}
}
