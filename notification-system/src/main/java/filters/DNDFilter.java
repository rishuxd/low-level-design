package filters;

import java.time.LocalTime;

import builder.Notification;
import enums.Type;
import models.User;

public class DNDFilter extends NotificationFilter {
    public String filter(Notification n, User u){
        if(n.getType() != Type.OTP){
            int hour = LocalTime.now().getHour();
            if(hour >= 22 || hour < 8) return "BLOCKED";
        }
        if(next != null) return next.filter(n, u);
        return "PASS";
    }
}
