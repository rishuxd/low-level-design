package models;

import java.util.List;

public class PickupOrder extends Order {
    private String restaurantAdd;
    
    public PickupOrder(User user, Restaurant res, List<MenuItem> items){
        super(user, res, items);
        this.restaurantAdd = res.getLocation();
    }

    public String getAdd(){
        return restaurantAdd;
    }

    public String getType(){
        return "Delivery";
    }
}


