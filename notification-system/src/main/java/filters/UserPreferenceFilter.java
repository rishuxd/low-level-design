package filters;

import builder.Notification;
import models.User;

public class UserPreferenceFilter extends NotificationFilter {
    public String filter(Notification n, User user){
        if(!user.isOpted(n.getChannel())) return "BLOCKED";
        if (next != null) return next.filter(n, user);
        return "PASS";
    }
}
