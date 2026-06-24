package managers;

import java.util.ArrayList;
import java.util.List;

import models.Order;

public class OrderManager {
    private List<Order> orders = new ArrayList<>();
    private OrderManager(){}

    private static class Holder{
        private static final OrderManager INSTANCE = new OrderManager();
    }

    public static OrderManager getInstance(){
        return Holder.INSTANCE;
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public List<Order> listOrders(){
        return orders;
    }
}
