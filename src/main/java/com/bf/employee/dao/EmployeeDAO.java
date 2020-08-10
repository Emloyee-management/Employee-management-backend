package com.bf.employee.dao;

import com.bf.employee.entity.Employee;
import com.bf.employee.entity.User;

/*
* DAO interface for Employee
*/
public interface EmployeeDAO {
    /*
    * Register Employee to DB
    */
    int registerEmployee(Employee employee);
    int updateEmployee(Employee employee);
    int getEmployeeIdByPersonId(int personId);
}
