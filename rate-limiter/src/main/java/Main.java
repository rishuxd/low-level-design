import services.RateLimitService;
import models.User;
import enums.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RateLimitService limiter = RateLimitService.getInstance();

        User freeUser = new User("user1", UserTier.FREE); // 10 req in 60 sec
        User premiumUser = new User("user2", UserTier.PREMIUM); // 100 req in 60 sec

        System.out.println("=== Free User Requests ===");
        for (int i = 1; i <= 15; i++) {
            boolean allowed = limiter.allowRequest(freeUser);
            System.out.println("Request " + i + " for Free User: " + (allowed ? "ALLOWED" : "BLOCKED"));
            Thread.sleep(100);
        }

        System.out.println("\n=== Premium User Requests ===");
        for (int i = 1; i <= 120; i++) {
            boolean allowed = limiter.allowRequest(premiumUser);
            System.out.println("Request " + i + " for Premium User: " + (allowed ? "ALLOWED" : "BLOCKED"));
            Thread.sleep(100);
        }
    }
}
