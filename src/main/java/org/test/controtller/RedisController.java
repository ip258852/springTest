package org.test.controtller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;

@RestController
public class RedisController {
    @RequestMapping("/setredis")
    public  String setRedis(HttpSession session){

        user user = new user();
        user.setId("A1005106");
        session.setAttribute("uid",user);
        System.out.println();session.getAttribute("uid").toString();
        return "ok";
    }

    @RequestMapping("/getredis")
    public String getRedis(HttpSession session){
        user us = (user)session.getAttribute("uid");
        return  us.getId();
    }

    @RequestMapping("/re")
    public void re(HttpServletResponse response){
        try {
            response.sendRedirect("/setredis");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class user implements Serializable {
    private String id;

    public user(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
