package com.bf.employee.service.serviceImpl;

import com.bf.employee.dao.ApplicationWorkFlowDAO;
import com.bf.employee.dao.EmployeeDAO;
import com.bf.employee.dao.PersonDAO;
import com.bf.employee.dao.UserDAO;
import com.bf.employee.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RegistrationService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private PersonDAO personDAO;
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private ApplicationWorkFlowDAO applicationWorkFlowDAO;


    @Transactional
    public boolean registerUser(User user) {

        if(userDAO.isUserExist(user)){ //the user EXISTS in DB
            return false;
        }else{ //the user does NOT EXIST in DB
            //person
            Person p = new Person();
            personDAO.registerPerson(p);
            //usesr
            user.setPersonId(p.getId());
            user.setCreateDate(now());
            user.setModificationDate(now());
            int userId = userDAO.registerUser(user);
            //employee
            Employee e = new Employee();
            e.setPersonId(p.getId());
            employeeDAO.registerEmployee(e);
            //appWorkFlow
            ApplicationWorkFlow wf = new ApplicationWorkFlow();
            wf.setEmployeeId(e.getId());
            wf.setStatus("Open");
            wf.setCreatedDate(now());
            wf.setType("onboarding");
            applicationWorkFlowDAO.registerApplicationWorkFlow(wf);

//            RegistrationResponse regResponse = RegistrationResponse.builder()
//                                                                .userId(userId)
//                                                                .employeeId(e.getId())
//                                                                .personId(p.getId())
//                                                                .applicationWorkFlowId(wf.getId())
//                                                                .build();
            return true;
        }
    }

    public String now(){
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String now = simpleDateFormat.format(new Date());
        return now;
    }


}
