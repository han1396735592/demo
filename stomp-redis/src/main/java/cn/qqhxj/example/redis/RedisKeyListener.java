package cn.qqhxj.example.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

@Slf4j
//@Component
public class RedisKeyListener extends KeyExpirationEventMessageListener {
    public RedisKeyListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        super.onMessage(message, pattern);
        log.info("getChannel = {}", new String(message.getChannel()));
        log.info("body = {}", new String(message.getBody()));
        log.info("pattern = {}", new String(pattern));
    }
}
