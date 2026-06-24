package models;

import java.util.ArrayList;
import java.util.List;

import strategies.PaymentStrategy;

public abstract class Order {
    private static int nextOrderId = 0;
    private int orderId;

    private User user;
    private Restaurant res;
    private List<MenuItem> items = new ArrayList<>();
    
    private double totalAmt;
    private PaymentStrategy ps;

    public Order(User user, Restaurant res, List<MenuItem> items){
        if(user == null) throw new IllegalArgumentException("User required!");
        if(res == null) throw new IllegalArgumentException("Restaurant required!");
        if(items == null || items.isEmpty()) throw new IllegalArgumentException("Items required!");

        orderId = ++nextOrderId;
        this.user = user;
        this.res =  res;
        this.items = List.copyOf(items);

        this.totalAmt = calculateTotal();
    }

    private double calculateTotal(){
        return items.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    public boolean processOrder(){
        if(ps == null){
            throw new IllegalArgumentException("Payment Strategy required!");
        } 
        ps.pay(totalAmt);
        return true;
    }

    public abstract String getType();

    public int getOrderId(){
        return orderId;
    }

    public User getUser(){
        return user;
    }

    public Restaurant getRestaurant(){
        return res;
    }

    public List<MenuItem> getItems(){
        return items;
    }

    public double getTotalAmt(){
        return totalAmt;
    }

    public void setPaymentStrategy(PaymentStrategy ps){
        this.ps = ps;
    }
}


