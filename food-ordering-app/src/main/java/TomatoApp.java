import java.util.List;

import factories.OrderFactory;
import managers.*;
import models.*;
import services.NotificationService;
import strategies.PaymentStrategy;

public class TomatoApp {
    public TomatoApp(){
        init();
    }

    public void init(){
        Restaurant restaurant1 = new Restaurant("Bikaner", "Delhi");
        restaurant1.addMenuItem(new MenuItem("P1", "Chole Bhature", 120));
        restaurant1.addMenuItem(new MenuItem("P2", "Samosa", 15));

        Restaurant restaurant2 = new Restaurant("Haldiram", "Kolkata");
        restaurant2.addMenuItem(new MenuItem("P1", "Raj Kachori", 80));
        restaurant2.addMenuItem(new MenuItem("P2", "Pav Bhaji", 100));
        restaurant2.addMenuItem(new MenuItem("P3", "Dhokla", 50));

        Restaurant restaurant3 = new Restaurant("Saravana Bhavan", "Chennai");
        restaurant3.addMenuItem(new MenuItem("P1", "Masala Dosa", 90));
        restaurant3.addMenuItem(new MenuItem("P2", "Idli Vada", 60));
        restaurant3.addMenuItem(new MenuItem("P3", "Filter Coffee", 30));

        RestaurantManager restaurantManager = RestaurantManager.getInstance();
        restaurantManager.addRestaurant(restaurant1);
        restaurantManager.addRestaurant(restaurant2);
        restaurantManager.addRestaurant(restaurant3);
    }
    
    public List<Restaurant> listRestaurants(String location){
        return RestaurantManager.getInstance().getRestaurantsByLocation(location);
    }

    public void selectRestaurant(User user, Restaurant res){    
        user.getUserCart().setRestaurant(res);
    }

    public void addToCart(User user, String itemCode){
        Restaurant res = user.getUserCart().getRestaurant();
        
        if(res == null){
            System.out.println("Select restaurant first!");
            throw new NullPointerException();
        }
        
        for(MenuItem it: res.getMenu()){
            if(it.getCode().equals(itemCode)){
                user.getUserCart().addItem(it);
                break;
            }
        }
    }
    
    public Order checkout(User user, PaymentStrategy ps, String orderType){
        if(user.getUserCart().getItems().isEmpty()){
            System.out.println("Cart is empty!");
            return null;
        }

        Order order = OrderFactory.createOrder(user, user.getUserCart().getRestaurant(), user.getUserCart().getItems(), ps, orderType);
        OrderManager.getInstance().addOrder(order);
        return order;
    }

    public void pay(User user, Order order){
        boolean result = order.processOrder();
        
        if(result){
            NotificationService.notify(order);
            user.getUserCart().clearCart();
        }
    }

    public void printUserCart(User user){
        System.out.println("Items in cart:");
        System.out.println("------------------------------------");
        for (MenuItem item : user.getUserCart().getItems()) {
            System.out.println(item.getCode() + " : " + item.getName() + " : ₹" + item.getPrice());
        }
        System.out.println("------------------------------------");
        System.out.println("Grand total : ₹" + user.getUserCart().getCartAmt());
    }
}
