package com.bf.employee.service.serviceImpl;

import com.bf.employee.dao.EmployeeDAO;
import com.bf.employee.entity.Employee;
import com.bf.employee.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/*
* Service class for Employee
*/
@Service
public class EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;

    /*
    * Register Employee to DB
    */
    @Transactional
    public void registerEmployee(Employee employee){ employeeDAO.registerEmployee(employee); }

    /*
    * Create a String that follows the format: "Maker_Model_Color". e.g. "Kia_k4_Black"
    */
    public String carFormatter(String Maker ,String Model, String Color){
        String car = Maker+"_"+Model+"_"+Color;
        return car;
    }


}
