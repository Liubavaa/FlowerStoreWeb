package com.example.demo.flowers;


public enum FlowerColor {
    RED("Red"), BLUE("Blue"),
    YELLOW("Yellow"), WHITE("White");
    private final String stringRepresentation;

    FlowerColor(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    @Override
    public String toString() {
        return stringRepresentation;
    }
}

