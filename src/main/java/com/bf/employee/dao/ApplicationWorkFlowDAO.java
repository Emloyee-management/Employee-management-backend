package com.bf.employee.dao;

import com.bf.employee.entity.ApplicationWorkFlow;

/*
* DAO interface for AppWorkFlow
*/
public interface ApplicationWorkFlowDAO {
    /*
    * Register ApplicationWorkFlow to DB
    */
    int registerApplicationWorkFlow(ApplicationWorkFlow applicationWorkFlow);
    void updateStatus(String type, int employeeId, String changedStatus, String now);

}
