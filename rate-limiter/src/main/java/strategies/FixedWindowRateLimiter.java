package strategies;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import enums.RateLimiterType;
import models.RateLimitConfig;

public class FixedWindowRateLimiter extends Limiter {
    private final Map<String, Integer> requestCount = new ConcurrentHashMap<>();
    private final Map<String, Long> windowStart = new HashMap<>();

    public FixedWindowRateLimiter(RateLimitConfig config){
        super(config, RateLimiterType.FIXED_WINDOW);
    }

    public boolean allowRequest(String userId){
        long currReqWindow = System.currentTimeMillis() / 1000 / config.getWindowInSeconds();


    }
}
