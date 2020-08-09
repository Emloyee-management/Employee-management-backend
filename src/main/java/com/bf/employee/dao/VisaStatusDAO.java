package com.bf.employee.dao;

import com.bf.employee.entity.VisaStatus;

import java.util.List;

/*
 * DAO interface for VisaStatus
 */
public interface VisaStatusDAO {

    /*
     * Save a User into DB and return ID
     */
    int registerVisaStatus(VisaStatus visaStatus);

    public int findByUserName(String userName);

    VisaStatus getVisaInfo(int employeeVisaStatusId);

    Boolean updateVisaType(int employeeVisaStatusId, String visaType);

    List<VisaStatus> getAll();
}

