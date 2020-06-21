package cn.qqhxj.example.stomp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class StompMessgaeHanlder {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @MessageMapping("/message")
    @SendTo("/topic/sub")
    public String hanlder(@Payload String data) {
        log.info("data = {}", data);
        return "hello"+data;
    }

    @Scheduled(fixedDelay = 1000)
    public void hanlder() {
        messagingTemplate.send("/topic/sub", new GenericMessage("hello".getBytes()) {
        });
    }
}
