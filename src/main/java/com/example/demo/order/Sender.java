package com.example.demo.order;

import com.example.demo.user.AppUser;

public class Sender implements OrderUser{
    private final AppUser user;

    public Sender(AppUser user) {
        this.user = user;
    }

    @Override
    public void update(StatusType status) {
        user.setMessage("Sent to you order is "+status);
    }
}
