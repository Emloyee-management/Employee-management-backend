package com.bf.employee.dao;

import com.bf.employee.entity.Employee;

/*
* DAO interface for Employee
*/
public interface EmployeeDAO {
    /*
    * Register Employee to DB
    */
    int registerEmployee(Employee employee);

}
