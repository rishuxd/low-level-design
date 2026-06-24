package observers;

import builder.Notification;
import enums.Status;

public class AuditLogger implements NotificationObserver {
    public void onStatusChange(Notification n, Status oldStatus, Status newStatus){
        System.out.println("Notification " + n.getId() + ": Status changed from " + oldStatus + " to " + newStatus);
    }
}
