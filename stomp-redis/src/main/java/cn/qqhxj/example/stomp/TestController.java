package cn.qqhxj.example.stomp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @GetMapping("/sendAll")
    public void test(String msg){
        GenericMessage<String> genericMessage = new GenericMessage<>(msg);
        messagingTemplate.send("all", genericMessage);
    }

}
