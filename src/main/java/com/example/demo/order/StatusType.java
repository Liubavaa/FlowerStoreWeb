package com.example.demo.order;


public enum StatusType {
    CREATED, SEND, DERIVED;

    public String toString() {
        return switch (this) {
            case CREATED -> "created";
            case SEND -> "send";
            default -> "derived";
        };
    }
}
