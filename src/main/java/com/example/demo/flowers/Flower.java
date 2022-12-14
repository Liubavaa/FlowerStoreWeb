package com.example.demo.flowers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Flower extends Item{
    @Id
    @GeneratedValue
    private Long id;
    private double sepalLength;
    private FlowerColor color;
    private double price;
    private FlowerType flowerType;
    @Override
    public String getDescription() {
        return color+
                " "+flowerType+
                " that costs "+price;
    }
}
