package strategies;

import builder.Notification;
import models.User;

public interface NotificationChannel {
    boolean send(User user, Notification notification);
}
