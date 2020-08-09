package com.bf.employee.controller;

import com.bf.employee.entity.*;
import com.bf.employee.service.serviceImpl.*;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.*;

@RestController
public class ApplicationForm {
    @Resource
    private HttpServletRequest request;
    @Autowired
    private PersonService personService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private VisaStatusService visaStatusService;
    @Autowired
    private AddressService addressService;

    /*
     * Controller method for testing parsing HTTP request parameters
     * */
    @RequestMapping(path = "/test", consumes = "application/json")
    public void test(@RequestBody Map<String, String> something) {
        System.out.println(something.get("key"));
    }

    /*
     * Controller method for parsing HTTP request and create Person, Employee objects, and save them to the DB.
     */
    @RequestMapping(path = "/applicationForm", consumes = "application/json", method = RequestMethod.POST)
    @Transactional
    public void parseApplicationForm(@RequestBody Map<String, String> applicationForm) throws ParseException {
        System.out.println("yoyo");
//        System.out.println(applicationForm.get("formData"));

        /*
         * Create Person, Employee, Address, and VisaStatus and start Onboarding process.
         */
        Person person1 = Person.builder()
                .firstName(applicationForm.get("firstName"))
                .lastName(applicationForm.get("lastName"))
                .middleName(applicationForm.get("middleName"))
                .cellphone(applicationForm.get("cellphone"))
                .alternatePhone(applicationForm.get("alternatePhone"))
                .ssn(applicationForm.get("ssn"))
                .dob(applicationForm.get("dob"))
                .gender(applicationForm.get("gender"))
                .email(applicationForm.get("email"))
                .build();
//        String car = employeeService.carFormatter(applicationForm.get("car_maker"),
//                applicationForm.get("car_model"),
//                applicationForm.get("car_color"));
        Employee employee1 = Employee.builder()
//                    .personId()
                .avatar(applicationForm.get("avatar"))
                .car(applicationForm.get("car"))
//                    .visaType()
                .visaStartDate(applicationForm.get("visaStartDate"))
                .visaEndDate(applicationForm.get("visaEndDate"))
                .driverLicence(applicationForm.get("driverLicence"))
                .driverExpirationDate(applicationForm.get("driverL_expirationDate"))
                .build();
        int isVisaStatusActive = visaStatusService.isVisaStatusActive(applicationForm.get("visaEndDate"));
        VisaStatus visaStatus1 = VisaStatus.builder()
                .CreateUser(request.getParameter("userName"))
                .VisaType(applicationForm.get("visaType"))
                .Active(isVisaStatusActive)
                .build();
        Address address1 = Address.builder()
                .addressLine1(applicationForm.get("addressLine1"))
                .addressLine2(applicationForm.get("addressLine2"))
                .city(applicationForm.get("city"))
                .zipcode(applicationForm.get("zipcode"))
                .stateName(applicationForm.get("stateName"))
                .stateAbbr(applicationForm.get("stateAbbr"))
//                .personId()
                .build();

        boolean isOnBoard = personService.onBoardEmployee(person1, employee1, address1, visaStatus1);
        System.out.println("isOnBoard: " + isOnBoard);

        /*
         * Create Reference : Person, Address, Contact
         */
        Person reference = Person.builder()
                .firstName(applicationForm.get("reference_firstName"))
                .lastName(applicationForm.get("reference_lastName"))
                .middleName(applicationForm.get("reference_middleName"))
                .cellphone(applicationForm.get("reference_cellphone"))
                .ssn(applicationForm.get("null"))
                .email(applicationForm.get("reference_email"))
                .build();
        Address reference_address = Address.builder()
                .addressLine1(applicationForm.get("reference_addressLine1"))
                .addressLine2(applicationForm.get("reference_addressLine2"))
                .city(applicationForm.get("reference_city"))
                .zipcode(applicationForm.get("reference_zipcode"))
                .stateName(applicationForm.get("reference_stateName"))
                .stateAbbr(applicationForm.get("reference_stateAbbr"))
//                .personId()
                .build();
        Contact reference_contact = Contact.builder()
//                .personId()
                .relationship(applicationForm.get("reference_relationship"))
                .build();
        boolean isReference = personService.addReference(reference, reference_address, reference_contact);
        System.out.println("isReference: " + isReference);

        /*
         * Create Emergency Contacts
         */
        Person emergency = Person.builder()
                .firstName(applicationForm.get("emergency_firstName"))
                .lastName(applicationForm.get("emergency_lastName"))
                .middleName(applicationForm.get("emergency_middleName"))
                .cellphone(applicationForm.get("emergency_cellphone"))
                .email(applicationForm.get("emergency_email"))
                .build();
        Contact emergency_contact = Contact.builder()
                .relationship(applicationForm.get("emergency_relationship")).build();
//                .personId()
        boolean isEmergency = personService.addEmergencyContact(emergency, emergency_contact);
        System.out.println("isEmergency: " + isEmergency);

    }


}
