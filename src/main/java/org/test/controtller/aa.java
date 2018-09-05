package org.test.controtller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class aa {

    @RequestMapping(value = "/123")
    public String myHello(){
        return "hello";
    }
}
