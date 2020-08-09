package com.bf.employee.controller;

import com.bf.employee.entity.HREmailResponse;
import com.bf.employee.entity.HRPersonalInfoResponse;
import com.bf.employee.entity.RegistrationToken;
import com.bf.employee.service.PersonService;
import com.bf.employee.service.serviceImpl.ApplicationWorkFlowService;
import com.bf.employee.service.serviceImpl.RegistrationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hiring")
public class HRHiring {
    @Autowired
    RegistrationTokenService registrationTokenService;
    @Autowired
    PersonService personService;

    @Autowired
    ApplicationWorkFlowService applicationWorkFlowService;


    @RequestMapping(path = "/generateRegistrationToken", consumes="application/json")
    public HREmailResponse GenerateRegToken(@RequestBody Map<String, String> applicationForm){
        String regTok = registrationTokenService.generateRegToken(applicationForm.get("email"),applicationForm.get("userId"));
        String msg = "Please use the provided Registration Token to create your account: " + regTok;
        HREmailResponse email = HREmailResponse.builder().recipientEmail(applicationForm.get("email")).msg(msg).build();
        return email;
    }

    @RequestMapping("/personInfoList")
    public List<HRPersonalInfoResponse> getAllPersonalInfo(){
        List<HRPersonalInfoResponse> personInfoList = personService.getPersonList();
        return personInfoList;
    }

    @RequestMapping("/StatusChange")
    public void changeStatus(@RequestBody Map<String, String> statusChangeRequest){
        String type = statusChangeRequest.get("type");
        int employeeId = Integer.valueOf(statusChangeRequest.get("employeeId"));
        String changedStatus = statusChangeRequest.get("changedStatus");

        applicationWorkFlowService.changeStatus(type, employeeId, changedStatus);


    }
}
