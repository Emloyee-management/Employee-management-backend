package com.bf.employee.controller;


import com.bf.employee.entity.VisaStatus;

import com.bf.employee.service.serviceImpl.VisaStatusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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


    @GetMapping("/visaStatus")
    public Object getVisaStatus() {

        Integer employeeVisaStatusId = Integer.parseInt(request.getParameter("visaStatusId"));
        VisaStatus visaStatus = visaStatusService.getVisaStatus(employeeVisaStatusId);
        return visaStatus;
    }

    @PostMapping("/visaStatus")
    public Boolean updateVisaStatus() {
        Integer employeeVisaStatusId = Integer.parseInt(request.getParameter("visaStatusId"));
        String visaType = request.getParameter("visaType");
        Boolean updateResult = visaStatusService.updateVisaType(employeeVisaStatusId, visaType);
        return updateResult;
    }
}
