package org.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.test.interceptor.TestInBoundInterceptor;
import org.test.interceptor.TestInterceptor;
import org.test.service.TestService;

/**
 * Created by Kobeishandsome on 2018/9/21.
 */
@Configuration
@EnableWebSocketMessageBroker
public class wsCofig extends AbstractWebSocketMessageBrokerConfigurer{

    // 连接站点配置
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/endpoint") // stomp 连接点
                .setAllowedOrigins("*").addInterceptors(new TestInterceptor());
    }


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        super.configureMessageBroker(registry);
        registry.enableSimpleBroker("/topic"); // 推送消息前缀
        registry.setApplicationDestinationPrefixes("/app") // 应用请求前缀
                .setUserDestinationPrefix("/user/");  // 推送用户前缀
    }

}
