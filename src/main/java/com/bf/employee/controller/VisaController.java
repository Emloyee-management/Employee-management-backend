package com.bf.employee.controller;


import com.bf.employee.entity.VisaStatus;

import com.bf.employee.service.VisaStatusService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class VisaController {
    @Resource
    private VisaStatusService visaStatusService;
    @Resource
    private HttpServletRequest request;


    @RequestMapping("/visaStatus")
    public Object getVisaStatus() {
        System.out.println("hi");
        Integer employeeVisaStatusId = Integer.parseInt(request.getParameter("visaStatusId"));
        VisaStatus visaStatus = visaStatusService.getVisaStatus(employeeVisaStatusId);
        return visaStatus;
    }
}
