package observers;

import builder.Notification;
import enums.Status;

public class AnalyticsTracker implements NotificationObserver {
    private int sentCount = 0;
    private int failedCount = 0;

    private AnalyticsTracker() {}

    private static class Holder {
        private static final AnalyticsTracker INSTANCE = new AnalyticsTracker();
    }

    public static AnalyticsTracker getInstance() {
        return Holder.INSTANCE;
    }

    public void onStatusChange(Notification n, Status oldStatus, Status newStatus) {
        if(newStatus == Status.FAILED) failedCount++;
        else if(newStatus == Status.SENT) sentCount++;
        printAnalytics();
    }

    public void printAnalytics(){
        System.out.println("Sent Count: " + sentCount); 
        System.out.println("Failed Count: " + failedCount); 
    }
}
