import builder.Notification;
import engines.NotificationEngine;
import enums.Channel;
import enums.Type;
import filters.DNDFilter;
import filters.NotificationFilter;
import filters.RateLimitFilter;
import filters.UserPreferenceFilter;
import models.User;
import observers.AnalyticsTracker;
import observers.AuditLogger;

public class Main {
    public static void main(String[] args) {
        NotificationFilter filterChain = new UserPreferenceFilter();
        filterChain.setNext(RateLimitFilter.getInstance().setNext(new DNDFilter()));

        NotificationEngine.initialize(filterChain);
        NotificationEngine engine = NotificationEngine.getInstance();

        engine.addObserver(new AuditLogger());
        engine.addObserver(AnalyticsTracker.getInstance());

        //create user
        User user = new User("1", "Rishi", "rishi@gmail.com", "1234554321", "exhhfjahjksfaiajfalfb");
        user.optIn(Channel.SMS);
        user.optIn(Channel.EMAIL);

        //create notification
        Notification notification = new Notification.Builder("1", "Your otp is 1234.", Channel.SMS, Type.OTP).subject("Login OTP!").build();
        
        engine.send(notification, user);
    }
}
