package org.test.controtller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.test.beans.User;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    Log log = LogFactory.getLog(RestController.class);

    @RequestMapping(value = "/111",method = RequestMethod.GET)
    @ResponseBody
    public Student testJsonRes(HttpServletResponse response){
        response.setHeader("token","my name is joke");
        return new Student(123456);
    }

    @RequestMapping(value = "/2252",method = RequestMethod.POST)
    @ResponseBody
    public Student testRequest(@RequestHeader(value = "Content-Type") String req){
        System.out.println(req);
        return new Student(123456);
    }

    @PostMapping(value = "/45678")
    @ResponseBody
    public Student testReqBodyJson(@RequestBody Student student){

        System.out.println(student.toString());
        return student;
    }
}

class Student{
    public Student(int id) {
        this.id = id;
    }
    public Student( ) {

    }
    public int getId() {
        return id;
    }

    private int id;

    @Override
    public String toString() {
        return String.format("My id is %d",id);
    }
}
