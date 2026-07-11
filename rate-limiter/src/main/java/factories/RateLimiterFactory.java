package factories;

import enums.RateLimitType;
import models.RateLimitConfig;
import strategies.FixedWindowRateLimiter;
import strategies.Limiter;
import strategies.SlidingWindowRateLimiter;
import strategies.TokenBucketRateLimiter;

public class RateLimiterFactory {
    public static Limiter create(RateLimitType type, RateLimitConfig config) {
        switch (type) {
            case FIXED_WINDOW:
                return new FixedWindowRateLimiter(config);

            case SLIDING_WINDOW:
                return new SlidingWindowRateLimiter(config);

            case TOKEN_BUCKET:
                return new TokenBucketRateLimiter(config);

            default:
                throw new IllegalArgumentException("This rate limiter doesn't exist!");
        }
    }
}
