package strategies;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import enums.RateLimitType;
import models.RateLimitConfig;

public class FixedWindowRateLimiter extends Limiter {
    private final Map<String, Integer> requestCount = new ConcurrentHashMap<>();
    private final Map<String, Long> windowStart = new HashMap<>();

    public FixedWindowRateLimiter(RateLimitConfig config) {
        super(config, RateLimitType.FIXED_WINDOW);
    }

    public boolean allowRequest(String userId) {
        AtomicBoolean allowed = new AtomicBoolean(false);
        long currReqWindow = System.currentTimeMillis() / 1000 / config.getWindowInSeconds();

        requestCount.compute(userId, (id, count) -> {
            long lastReqWindow = windowStart.getOrDefault(id, currReqWindow);

            if (lastReqWindow != currReqWindow) {
                windowStart.put(id, currReqWindow);
                allowed.set(true);
                return 1;
            }

            if (count == null)
                count = 0;

            if (count < config.getMaxRequests()) {
                allowed.set(true);
                return count + 1;
            }

            return count;
        });

        return allowed.get();
    }
}
