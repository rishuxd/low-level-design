package engines;

import java.util.ArrayList;
import java.util.List;

import builder.Notification;
import enums.Status;
import factories.ChannelFactory;
import filters.NotificationFilter;
import models.User;
import observers.NotificationObserver;
import strategies.NotificationChannel;

public class NotificationEngine {
    private static NotificationEngine instance;
    
    private final NotificationFilter filterChain;
    private List<NotificationObserver> observers = new ArrayList<>();

    private NotificationEngine(NotificationFilter filterChain){
        this.filterChain = filterChain;
    }
    
    public static synchronized void initialize(NotificationFilter filterChain){
        if(instance == null) instance = new NotificationEngine(filterChain);
    }

    public static NotificationEngine getInstance(){
        if(instance == null) throw new IllegalStateException("Call initialize first!");
        return instance;
    }

    public void addObserver(NotificationObserver n){
        observers.add(n);
    }

    public void removeObserver(NotificationObserver n){
        observers.remove(n);
    }

    public void notifyObservers(Notification n, Status oldStatus, Status newStatus){
        observers.forEach(o -> o.onStatusChange(n, oldStatus, newStatus));
    }

    public void send(Notification n, User u){
        if(filterChain.filter(n, u).equals("BLOCKED")){
            notifyObservers(n, n.getStatus(), Status.FAILED);
            n.setStatus(Status.FAILED);
            return;
        }

        NotificationChannel nChannel = ChannelFactory.create(n.getChannel());
        if(nChannel.send(u, n)){
            notifyObservers(n, n.getStatus(), Status.SENT);
            n.setStatus(Status.SENT);
        }else{
            notifyObservers(n, n.getStatus(), Status.FAILED);
            n.setStatus(Status.FAILED);
        }
    }
}
