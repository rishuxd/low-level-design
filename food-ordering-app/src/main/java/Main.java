import java.rmi.server.SkeletonMismatchException;
import java.util.List;

import models.MenuItem;
import models.Order;
import models.Restaurant;
import models.User;
import strategies.UpiPaymentStrategy;

public class Main {
    public static void main(String[] args) {
        TomatoApp tomato = new TomatoApp();

        User user = new User(101, "Rishi", "Azamgarh");
        System.out.println("User: " + user.getName() + " is active.");

        List<Restaurant> restaurantList = tomato.listRestaurants("Delhi");
        if (restaurantList.isEmpty()) {
            System.out.println("No restaurants found!");
            return;
        }

        System.out.println("Found Restaurants:");
        for (Restaurant restaurant : restaurantList) {
            System.out.println(" - " + restaurant.getName());
        }

        tomato.selectRestaurant(user, restaurantList.get(0));
        System.out.println("Selected restaurant: " + restaurantList.get(0).getName());
        
        System.out.println(restaurantList.get(0).getName()+ " Menu:");
        for(MenuItem it: restaurantList.get(0).getMenu()){
             System.out.println(" - " + it.getCode() + ": " + it.getName() + ", " + it.getPrice());
        }

        tomato.addToCart(user, "P1");
        tomato.addToCart(user, "P2");

        tomato.printUserCart(user);

        Order order = tomato.checkout(user, new UpiPaymentStrategy("8940243477"), "Delivery");

        tomato.pay(user, order);
    }
}   
