package observers;

import builder.Notification;
import enums.Status;

public interface NotificationObserver {
    void onStatusChange(Notification n, Status oldStatus, Status newStatus);
}
