package cn.qqhxj.example.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

//@Configuration
public class RedisConfig {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Scheduled(fixedDelay = 15000)
    public void test(){
        redisTemplate.opsForHash().put("id", "hxj","666" );
        redisTemplate.expire("id", 5, TimeUnit.SECONDS);
    }

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        return container;
    }



}
