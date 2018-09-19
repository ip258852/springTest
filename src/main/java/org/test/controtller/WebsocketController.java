package org.test.controtller;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * Created by Kobeishandsome on 2018/9/19.
 */
@Controller
public class WebsocketController {

    //Controller的分支 For 前端的sendTo /app/hello,/app需要與mvc-dispattcher內設定相同
    //傳給前端有訂閱這個URL的人,topic要與 <websocket:simple-broker prefix="/topic"/>相同
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting(String message) throws Exception {
        return message;
    }

    // 這邊撰寫事件,輸入參數只能唯一
    @EventListener
    public void SessionDisconnectEvent(SessionDisconnectEvent event1) {
        System.out.println("SessionDisconnectEvent");
    }
}

class Greeting {
    private String content;

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

class HelloMessage {
    private String name;

    public String getName() {
        return name;
    }
}