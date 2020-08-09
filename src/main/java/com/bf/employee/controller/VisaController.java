package com.bf.employee.controller;


import com.bf.employee.entity.VisaStatus;

import com.bf.employee.service.serviceImpl.VisaStatusService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;

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

    @Transactional
    @RequestMapping(value = "/visaList", method = RequestMethod.GET)
    public List<VisaStatus> getAllVisa()
    {
        List<VisaStatus> res = visaStatusService.getAllVisa();
        return res;
    }
}
