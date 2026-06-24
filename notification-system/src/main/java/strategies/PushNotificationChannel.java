package strategies;

import builder.Notification;
import models.User;

public class PushNotificationChannel implements NotificationChannel {
    public boolean send(User user, Notification notification){
        System.out.println(notification.getType() + " notification " + notification.getId() + " sent to " + user.getName() + " on " + user.getDevToken());
        return true;
    }
}
