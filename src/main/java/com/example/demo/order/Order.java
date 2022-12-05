package com.example.demo.order;

import com.example.demo.delivery.Delivery;
import com.example.demo.flowers.Item;
import com.example.demo.payment.Payment;
import com.example.demo.user.AppUser;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

@Setter @Getter
public class Order {
    private LinkedList<OrderUser> users;
    private Payment payment;
    private Delivery delivery;
    private LinkedList<Item> items = new LinkedList<>();

    private StatusType status;

    public void setPaymentStrategy(Payment payment) {
        this.payment = payment;
    }
    public void setDeliveryStrategy(Delivery delivery) {
        this.delivery = delivery;
    }
    public void setStatus(StatusType status) { this.status = status; }

    public double calculateTotalPrice(){
        return payment.pay(items.stream().mapToDouble(Item::getPrice).sum()) + delivery.deliver(items);
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeFlower(Item item) {
        this.items.remove(item);
    }

    public void notifyUsers() {
        for (OrderUser user:users)
            user.update(status);
    }

    public void addSender(AppUser user){
        users.add(new Sender(user));
    }

    public void addReceiver(AppUser user){
        users.add(new Receiver(user));
    }
}
