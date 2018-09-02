package org.test.controtller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @RequestMapping(value = "/111",method = RequestMethod.GET)
    public Student myHello(HttpServletResponse response){
        response.setHeader("token","my name is joke");
        return new Student(123456);
    }
}

class Student{
    public Student(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    private int id;
}