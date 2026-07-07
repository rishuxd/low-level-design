package strategies;

import enums.RateLimiterType;
import models.RateLimitConfig;

public abstract class Limiter {
    protected final RateLimitConfig config;
    protected final RateLimiterType type;

    public Limiter(RateLimitConfig config, RateLimiterType type) {
        this.config = config;
        this.type = type;
    }

    public abstract boolean allowRequest(String userId);
}
