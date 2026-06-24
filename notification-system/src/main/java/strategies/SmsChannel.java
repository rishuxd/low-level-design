package strategies;

import builder.Notification;
import models.User;

public class SmsChannel implements NotificationChannel {
    public boolean send(User user, Notification notification){
        System.out.println(notification.getType() + " notification " + notification.getId() + " sent to " + user.getName() + " on " + user.getPhone());
        return true;
    }
}
