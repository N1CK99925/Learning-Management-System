package lms.lms.service;


import io.github.bucket4j.Bucket;
import io.github.bucket4j.BucketConfiguration;
import io.github.bucket4j.redis.lettuce.cas.LettuceBasedProxyManager;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RateLimitService {

    private final LettuceBasedProxyManager<String> proxyManager;

    public RateLimitService(LettuceBasedProxyManager<String> proxyManager) {
        this.proxyManager = proxyManager;
    }

    public Bucket resolveBucket(String key) {
        BucketConfiguration configuration = BucketConfiguration.builder()
                .addLimit(limit -> limit.capacity(10).refillGreedy(3, Duration.ofMinutes(1)))
                .build();

        
        return proxyManager.getProxy(key, () -> configuration);
    }
}
