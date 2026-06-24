package factories;

import java.util.List;

import models.DeliveryOrder;
import models.MenuItem;
import models.Order;
import models.PickupOrder;
import models.Restaurant;
import models.User;
import strategies.PaymentStrategy;

public class OrderFactory {
    public static Order createOrder(User user, Restaurant res, List<MenuItem> items, PaymentStrategy ps, String orderType){
        Order order = null;

        switch (orderType.toLowerCase()) {
            case "delivery":
                order = new DeliveryOrder(user, res, items);    ;
                break;

            case "pickup":
                order = new PickupOrder(user, res, items);
                break;

            default:
                break;
        }

        order.setPaymentStrategy(ps);
        return order;
    }
}
