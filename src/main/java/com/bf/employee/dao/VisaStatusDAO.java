package com.bf.employee.dao;

import com.bf.employee.entity.VisaStatus;

/*
* DAO interface for VisaStatus
*/
public interface VisaStatusDAO {

    /*
    * Save a User into DB
    */
    void registerVisaStatus(VisaStatus visaStatus);
    public int findByUserName(String userName);
}

    VisaStatus getVisaInfo(int employeeVisaStatusId);