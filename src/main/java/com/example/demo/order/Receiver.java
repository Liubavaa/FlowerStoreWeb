package com.example.demo.order;

import com.example.demo.user.AppUser;

public class Receiver implements OrderUser{
    private final AppUser user;

    public Receiver(AppUser user) {
        this.user = user;
    }

    @Override
    public void update(StatusType status) {
        user.setMessage("Order that you sent is "+status);
    }
}
