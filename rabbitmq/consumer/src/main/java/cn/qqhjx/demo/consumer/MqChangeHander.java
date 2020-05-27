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
//@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "mq.queue", autoDelete = "true"),
//        exchange = @Exchange(value = "mq.exchange", type = ExchangeTypes.FANOUT)))
public class MqChangeHander {

    @Autowired
    private  AmqpAdmin amqpAdmin;
    @Autowired
    private  AmqpTemplate amqpTemplate;


    @RabbitListener(queues = "test")
    public void ok(@Payload String msg, Channel channel, @Headers Map<String, Object> headers) {
        log.info("receive mg msg = {}", msg);

    }
}
