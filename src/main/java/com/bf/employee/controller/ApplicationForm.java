package com.bf.employee.controller;

import com.bf.employee.entity.Employee;
import com.bf.employee.entity.Person;
import com.bf.employee.entity.RegistrationToken;
import com.bf.employee.entity.User;
import com.bf.employee.service.serviceImpl.EmployeeService;
import com.bf.employee.service.serviceImpl.PersonService;
import com.bf.employee.service.serviceImpl.UserService;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class ApplicationForm {
    @Autowired
    private PersonService personService;
    @Autowired
    private EmployeeService employeeService;

    /*
    * Controller method for testing parsing HTTP request parameters
    * */
    @RequestMapping(path ="/test", consumes= "application/json")
    public void test(@RequestBody Map<String, String> something){
        System.out.println(something.get("key"));
    }

    /*
    * Controller method for parsing HTTP request and create Person, Employee objects, and save them to the DB.
    */
    @RequestMapping(path = "/applicationForm", consumes="application/json")
    @Transactional
    public void parseApplicationForm(@RequestBody Map<String, String> applicationForm){

        /*
        * Create a String that follows the format: ("mm-dd-yyyy").
        */
        String dob = personService.dateFormatter(applicationForm.get("dobYear"),
                                                applicationForm.get("dobMonth"),
                                                applicationForm.get("dobDate"));
        String visaStart = personService.dateFormatter(applicationForm.get("visaStartYear"),
                                                applicationForm.get("visaStartMonth"),
                                                applicationForm.get("visaStartDate"));
        String visaEnd = personService.dateFormatter(applicationForm.get("visaEndYear"),
                                                applicationForm.get("visaEndMonth"),
                                                applicationForm.get("visaEndDate"));
        String driverL_expirationDate = personService.dateFormatter(applicationForm.get("driverL_expirationYear"),
                                                applicationForm.get("driverL_expirationMonth"),
                                                applicationForm.get("driverL_expirationDate"));

        /*
         * Create Person Object and register the object to the DB
         */
        Person person1 = Person.builder()
                .firstName(applicationForm.get("firstName"))
                .lastName(applicationForm.get("lastName"))
                .middleName(applicationForm.get("middleName"))
                .cellphone(applicationForm.get("cellphone"))
                .alternatePhone(applicationForm.get("alternatePhone"))
                .ssn(applicationForm.get("ssn"))
                .dob(dob)
                .gender(applicationForm.get("gender"))
                .email(applicationForm.get("email"))
                .build();
        personService.registerPerson(person1);


        /*
         * Retrieve personID where firstName,lastName,email,and ssn matches
         * and create a String that follows the format: "Maker_Model_Color". e.g. "Kia_k4_Black"
         */
        int personID = personService.findIDByName(applicationForm.get("firstName"),
                applicationForm.get("lastName"),
                applicationForm.get("email"),
                applicationForm.get("ssn"));

        String car = employeeService.carFormatter(applicationForm.get("car_maker"),
                                    applicationForm.get("car_model"),
                                    applicationForm.get("car_color"));
        /*
         * Create Employee object and register the object to the DB
         */
        Employee employee1 = Employee.builder()
                .personId(personID)
                .avatar(applicationForm.get("avatar"))
                .car(car)
//                .visaType()  "visaType" : "value1", //get id from visaStatus, then put id
                .visaStartDate(visaStart)
                .visaEndDate(visaEnd)
                .driverLicence(applicationForm.get("driverLicence"))
                .driverExpirationDate(driverL_expirationDate)
                .build();

        employeeService.registerEmployee(employee1);

    }


}
