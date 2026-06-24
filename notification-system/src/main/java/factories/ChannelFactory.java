package factories;

import enums.Channel;
import strategies.EmailChannel;
import strategies.NotificationChannel;
import strategies.PushNotificationChannel;
import strategies.SmsChannel;

public class ChannelFactory {

    public static NotificationChannel create(Channel type){
        switch (type) {
            case SMS:
                return new SmsChannel();

            case EMAIL:
                return new EmailChannel();

            case PUSH:
                return new PushNotificationChannel();
            
            default:
                throw new IllegalArgumentException("Unsupported channel: " + type);
        }
    }
}
