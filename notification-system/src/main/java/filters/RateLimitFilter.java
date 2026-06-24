package filters;

import java.util.concurrent.ConcurrentHashMap;

import builder.Notification;
import models.User;

public class RateLimitFilter extends NotificationFilter{
    private int maxCnt = 5;
    private ConcurrentHashMap<String, Integer> mp = new ConcurrentHashMap<>();

    private RateLimitFilter(){}

    private static class Holder{
        private static final RateLimitFilter INSTANCE = new RateLimitFilter();
    }

    public static RateLimitFilter getInstance(){
        return Holder.INSTANCE;
    }

    public String filter(Notification n, User u){
        if(mp.getOrDefault(u.getId(), 0) >= maxCnt) return "BLOCKED";
        
        mp.merge(u.getId(), 1, Integer::sum);
        
        if(next != null) return next.filter(n, u);
        return "PASS";
    }
}
