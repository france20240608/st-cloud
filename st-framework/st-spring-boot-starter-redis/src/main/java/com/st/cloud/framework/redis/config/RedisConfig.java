package com.st.cloud.framework.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

// TODO 需要更换成redis集群配置
@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String springRedisHost;

    @Bean
    RedisStandaloneConfiguration redisStandaloneConfiguration() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName(springRedisHost);
        return config;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        // 设置默认的序列化器
        template.setDefaultSerializer(RedisSerializer.string());
        template.setKeySerializer(RedisSerializer.string());
        template.setValueSerializer(RedisSerializer.string());
        template.setHashKeySerializer(RedisSerializer.json());
        template.setHashValueSerializer(RedisSerializer.json());

        return template;
    }
}
