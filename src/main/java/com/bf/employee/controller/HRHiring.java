package com.bf.employee.controller;

import com.bf.employee.entity.HRemail;
import com.bf.employee.entity.RegistrationToken;
import com.bf.employee.service.serviceImpl.RegistrationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/hiring")
public class HRHiring {
    @Autowired
    RegistrationTokenService registrationTokenService;

    @RequestMapping(path = "/generateRegistrationToken", consumes="application/json")
    public HRemail GenerateRegToken(@RequestBody Map<String, String> applicationForm){
        String regTok = registrationTokenService.generateRegToken(applicationForm.get("email"),applicationForm.get("userId"));
        String msg = "Please use the provided Registration Token to create your account: " + regTok;
        HRemail email = HRemail.builder().recipientEmail(applicationForm.get("email")).msg(msg).build();


        return email;


    }
}
