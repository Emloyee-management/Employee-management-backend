package com.bf.employee.service.serviceImpl;

import com.bf.employee.dao.ApplicationWorkFlowDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ApplicationWorkFlowService {
    @Autowired
    ApplicationWorkFlowDAO applicationWorkFlowDAO;


    @Transactional
    public void changeStatus(String type, int employeeId, String changedStatus){
        String pattern = "MM/dd/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String now = simpleDateFormat.format(new Date());
        applicationWorkFlowDAO.updateStatus(type, employeeId, changedStatus, now);
    }



}
