package filters;

import builder.Notification;
import models.User;

public abstract class NotificationFilter {
    protected NotificationFilter next;
    public NotificationFilter setNext(NotificationFilter next){
        this.next = next;
        return next;
    }

    public abstract String filter(Notification n, User user);
}
