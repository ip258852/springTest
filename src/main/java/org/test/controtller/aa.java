package org.test.controtller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class aa {

    @RequestMapping(value = "/1545645645645623")
    public String myHello(){
        return "hello";
    }
}
