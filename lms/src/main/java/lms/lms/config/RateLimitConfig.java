package lms.lms.config;

import io.github.bucket4j.distributed.ExpirationAfterWriteStrategy;

import io.github.bucket4j.redis.lettuce.Bucket4jLettuce;
import io.github.bucket4j.redis.lettuce.cas.LettuceBasedProxyManager;
import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.codec.ByteArrayCodec;
import io.lettuce.core.codec.RedisCodec;
import io.lettuce.core.codec.StringCodec;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class RateLimitConfig {
    // 1. Define a standard RedisClient bean
    @Bean
    public RedisClient redisClient() {
        return RedisClient.create("redis://localhost:6379");
    }
    // 2. Create the specific connection Bucket4j needs
    @Bean(destroyMethod = "close")
    public StatefulRedisConnection<String, byte[]> bucket4jConnection(RedisClient redisClient) {
        return redisClient.connect(RedisCodec.of(StringCodec.UTF8, ByteArrayCodec.INSTANCE));
    }
    // 3. Configure the ProxyManager using the dedicated connection
    @Bean
    public LettuceBasedProxyManager<String> proxyManager(StatefulRedisConnection<String, byte[]> connection) {
        return Bucket4jLettuce
                .casBasedBuilder(connection)
                .expirationAfterWrite(ExpirationAfterWriteStrategy
                .basedOnTimeForRefillingBucketUpToMax(Duration.ofMinutes(2)))
                .build();
    }
}
