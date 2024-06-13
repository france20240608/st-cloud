//package com.st.cloud.framework.redis.config;
//
//import io.lettuce.core.resource.ClientResources;
//import io.lettuce.core.resource.DefaultClientResources;
//import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//
////@Configuration
//public class StRedisConfig {
//    @Primary
//    @Bean
//    @ConfigurationProperties(prefix = "spring.redis")
//    RedisProperties redisProperties(){
//        return new RedisProperties();
//    }
//
//    @Primary
//    @Bean(destroyMethod = "shutdown")
//    DefaultClientResources clientResources(){
//        return DefaultClientResources.builder().build();
//    }
//
//    @Primary
//    @Bean
//    LettuceConnectionFactory redisConnectionFactory(RedisProperties redisProperties, ClientResources clientResources) {
//        LettuceClientConfiguration config = new LettuceClientConfiguration();
//    }
//
//}
