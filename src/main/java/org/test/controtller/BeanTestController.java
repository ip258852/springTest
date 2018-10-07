package org.test.controtller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.test.beans.User;
import org.test.config.appContextIml;

@RestController
public class BeanTestController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/getBean")
    public String getbrean(){
//        User user = (User)context.getBean("user");
//        System.out.printf(user.getName());
        User user = (User) appContextIml.getBean("user");
        return user.toString();
    }
}
