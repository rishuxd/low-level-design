package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Restaurant res;
    private List<MenuItem> items = new ArrayList<>();
    
    public Cart(){
        res = null;
    }

    public void addItem(MenuItem item){
        if(res == null){
            System.out.println("Restaurant is not set!");
            return;
        }
        items.add(item);
    }
    
    public List<MenuItem> getItems(){
        return items;
    }

    public void setRestaurant(Restaurant res){
        this.res = res;
    }

    public Restaurant getRestaurant(){
        return res;
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public void clearCart(){
        items.clear();
        res = null;
    }

    public double getCartAmt(){
        double sum = 0;
        for(MenuItem it: items){
            sum += it.getPrice();
        }
        return sum;
    }
}
