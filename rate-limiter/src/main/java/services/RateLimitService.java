package services;

import java.util.HashMap;
import java.util.Map;

import enums.RateLimitType;
import enums.UserTier;
import factories.RateLimiterFactory;
import models.RateLimitConfig;
import models.User;
import strategies.Limiter;

public class RateLimitService {

    private final Map<UserTier, Limiter> rateLimiters = new HashMap<>();

    private RateLimitService() {
        rateLimiters.put(
                UserTier.FREE,
                RateLimiterFactory.create(
                        RateLimitType.TOKEN_BUCKET,
                        new RateLimitConfig(10, 60)));

        rateLimiters.put(
                UserTier.PREMIUM,
                RateLimiterFactory.create(
                        RateLimitType.FIXED_WINDOW,
                        new RateLimitConfig(100, 60)));
    }

    private static class Holder {
        private static final RateLimitService INSTANCE = new RateLimitService();
    }

    public static RateLimitService getInstance() {
        return Holder.INSTANCE;
    }

    public boolean allowRequest(User user) {
        Limiter limiter = rateLimiters.get(user.getUserTier());
        if (limiter == null)
            throw new IllegalArgumentException("No rate limiter configured for user tier: " + user.getUserTier());

        return limiter.allowRequest(user.getUserId());
    }
}
