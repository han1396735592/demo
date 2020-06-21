package com.example.stompredis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

@Slf4j
@EnableScheduling
@SpringBootApplication
public class StompRedisApplication{


    public static void main(String[] args) {
        SpringApplication.run(StompRedisApplication.class, args);
    }

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        return container;
    }

    @Scheduled(fixedDelay = 15000)
    public void test(){
        redisTemplate.opsForHash().put("id", "as","666" );
        redisTemplate.expire("id", 5, TimeUnit.SECONDS);
    }

}
