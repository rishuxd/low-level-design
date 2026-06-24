package models;

import java.util.List;

public class DeliveryOrder extends Order {
    private String userAdd;
    
    public DeliveryOrder(User user, Restaurant res, List<MenuItem> items){
        super(user, res, items);
        this.userAdd = user.getAdd();
    }

    public String getAdd(){
        return userAdd;
    }

    public String getType(){
        return "Delivery";
    }
}
