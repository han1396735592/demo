package cn.qqhxj.example.stomp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.messaging.SubProtocolWebSocketHandler;

@Slf4j
//@Component
public class StompSubProtocolWebSocketHandler extends SubProtocolWebSocketHandler {
    /**
     * Create a new {@code SubProtocolWebSocketHandler} for the given inbound and outbound channels.
     *
     * @param clientInboundChannel  the inbound {@code MessageChannel}
     * @param clientOutboundChannel the outbound {@code MessageChannel}
     */
    public StompSubProtocolWebSocketHandler(MessageChannel clientInboundChannel, SubscribableChannel clientOutboundChannel) {
        super(clientInboundChannel, clientOutboundChannel);
    }

    @Override
    public boolean isAutoStartup() {
        return false;
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        super.handleMessage(session, message);
        System.out.println(message);
        System.out.println(session);
    }
}
