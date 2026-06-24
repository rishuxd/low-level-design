package strategies;

import builder.Notification;
import models.User;

public class EmailChannel implements NotificationChannel {
    public boolean send(User user, Notification notification){
        System.out.println(notification.getType() + " notification " + notification.getId() + " sent to " + user.getName() + " on " + user.getEmail());
        return true;
    }
}
