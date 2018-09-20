package org.test.controtller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kobeishandsome on 2018/9/19.
 */
@Controller
public class WebsocketController {

    //Controller的分支 For 前端的sendTo /app/hello,/app需要與mvc-dispattcher內設定相同
    //傳給前端有訂閱這個URL的人,topic要與 <websocket:simple-broker prefix="/topic"/>相同
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String hello(String message) throws Exception {
        return "This is greetings,bitch";
    }

    //@DestinationVariable 可取得類似url解析的物件,變數名稱需與解析地方相同,此處為message
    @MessageMapping("/hello/{message}")
    @SendTo("/topic/greetings")
    public String helloA(@DestinationVariable String message) throws Exception {
        return "Your msg is " + message;
    }

    @MessageMapping("/json")
    @SendTo("/topic/json")
    public  Greeting json(){
        return  new Greeting("ABCD");
    }

    @MessageMapping("/oto")
    @SendToUser("/topic/oto")
    public String oto(){
        return "bitch";
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
