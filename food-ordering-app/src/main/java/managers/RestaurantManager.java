package managers;

import java.util.ArrayList;
import java.util.List;

import models.Restaurant;

public class RestaurantManager {
    
    private List<Restaurant> restaurants = new ArrayList<>();
    private RestaurantManager(){}
    
    private static class Holder {
        private static final RestaurantManager INSTANCE = new RestaurantManager();
    }

    public static RestaurantManager getInstance(){
        return Holder.INSTANCE;
    }
    
    public void addRestaurant(Restaurant r){
        restaurants.add(r);
    }

    public List<Restaurant> getRestaurantsByLocation(String loc){
        List<Restaurant> result = new ArrayList<>();
        loc = loc.toLowerCase();
        for(Restaurant r: restaurants){
            String temp = r.getLocation().toLowerCase();
            if(temp.equals(loc)) result.add(r);
        }
        return result;
    }
}
