package com.bf.employee.controller;

import com.bf.employee.entity.RegistrationToken;
import com.bf.employee.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ApplicationForm {
    /*
    * Controller method for testing parsing HTTP request parameters
    * */
    @RequestMapping(path ="/test", consumes= "application/json")
    public void test(@RequestBody Map<String, String> something){
        System.out.println(something.get("key"));
    }


}
