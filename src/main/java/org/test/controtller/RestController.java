package org.test.controtller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.test.beans.Students;
import org.test.beans.User;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    Log log = LogFactory.getLog(RestController.class);

    @RequestMapping(value = "/111",method = RequestMethod.GET)
    @ResponseBody
    public Students testJsonRes(HttpServletResponse response){
        response.setHeader("token","my name is joke");
        return new Students();
    }

    @RequestMapping(value = "/2252",method = RequestMethod.POST)
    @ResponseBody
    public Students testRequest(@RequestHeader(value = "Content-Type") String req){
        System.out.println(req);
        return new Students();
    }

    @PostMapping(value = "/45678")
    @ResponseBody
    public Students testReqBodyJson(@RequestBody Students student){

        System.out.println(student.toString());
        return student;
    }
}

