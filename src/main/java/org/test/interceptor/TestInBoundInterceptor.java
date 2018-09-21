package org.test.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.messaging.support.MessageHeaderAccessor;

/**
 * Created by Kobeishandsome on 2018/9/21.
 */
public class TestInBoundInterceptor extends ChannelInterceptorAdapter {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        System.out.println("preSend:" + message.getHeaders());
        // 將訊息存在 Accessor裡
        StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
        String userId = accessor.getFirstNativeHeader("userId");
        String simpSessionId = accessor.getHeader("simpSessionId").toString();

        System.out.println(userId);
        System.out.println(simpSessionId);
        return super.preSend(message, channel);
    }
}
