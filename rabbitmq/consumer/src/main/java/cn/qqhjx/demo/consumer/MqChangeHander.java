package cn.qqhjx.demo.consumer;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
@Slf4j
public class MqChangeHander {
    @RabbitListener(queues = "test")
    public void ok(@Payload String msg, Channel channel, @Headers Map<String, Object> headers) {
        log.info("receive mg msg = {}", msg);
    }
}
