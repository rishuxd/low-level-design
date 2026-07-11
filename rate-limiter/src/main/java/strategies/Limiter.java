package strategies;

import enums.RateLimitType;
import models.RateLimitConfig;

public abstract class Limiter {
    protected final RateLimitConfig config;
    protected final RateLimitType type;

    public Limiter(RateLimitConfig config, RateLimitType type) {
        this.config = config;
        this.type = type;
    }

    public abstract boolean allowRequest(String userId);
}
