package org.test.controtller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.security.Principal;


/**
 * Created by Kobeishandsome on 2018/9/19.
 */
@RestController
public class WebsocketController {

    @Autowired
    SimpMessagingTemplate template;

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
    public  Greeting sjson(){
        return  new Greeting("ABCD");
    }

    @MessageMapping("/jsonH")
    @SendTo("/topic/json")
    public  String rjson(User user){
        return  user.toString();
    }

    @MessageMapping("/oto")
    @SendToUser(value = "/topic/oto")
    public String oto(){
        return "bitch";
    }

    @MessageMapping("/trans")
    public void trans(){
        this.template.convertAndSend("/topic/json","/trans 傳送給 /topic/json 驗孕棒");
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

class User{
    private  int age ;
    private  String id;

    public User(){

    }

    @Override
    public String toString() {
        return "You'r "+this.id+" age is "+this.age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
