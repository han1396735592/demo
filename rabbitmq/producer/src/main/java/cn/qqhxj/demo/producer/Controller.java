package cn.qqhxj.demo.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final String routeKey="routeKey";
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/send")
    public String send(String msg) {
        rabbitTemplate.convertAndSend("change", routeKey,msg );
        return "ok";
    }

}
