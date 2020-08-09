package com.bf.employee.service.serviceImpl;

import com.bf.employee.dao.*;
import com.bf.employee.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/*
* Service class for Person
* */
@Service
public class PersonService {
    @Autowired
    private PersonDAO personDAO;
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private AddressDAO addressDAO;
    @Autowired
    private VisaStatusDAO visaStatusDAO;
    @Autowired
    private ContactDAO contactDAO;
    @Autowired
    private ApplicationWorkFlowDAO applicationWorkFlowDAO;


    @Transactional
    public boolean onBoardEmployee(Person person, Employee employee, Address address, VisaStatus visaStatus){

        //person
        int personId = personDAO.updatePerson(person);

        //visaStatus
        int vsId = visaStatusDAO.registerVisaStatus(visaStatus);

        //employee
        employee.setPersonId(personId);
        employee.setVisaStatusId(vsId);
        employee.setId(employeeDAO.getEmployeeIdByPersonId(personId));
        int employeeId = employeeDAO.updateEmployee(employee);

        //applicationWorkFlow
        applicationWorkFlowDAO.updateStatus("onboarding", employeeId, "Pending", now());

        //address
        address.setPersonId(personId);
        addressDAO.registerAddress(address);
        return true;


    }

    public String now(){
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String now = simpleDateFormat.format(new Date());
        return now;
    }

    public ApplicationWorkFlow buildAppWorkFlow(int employeeId){
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());

        ApplicationWorkFlow appWorkFlow = ApplicationWorkFlow.builder()
                .employeeId(employeeId)
                .createdDate(date)
                .modificationDate(date)
                .status("pending")
                .type("onboarding")
                .build();
        return appWorkFlow;
    }

    public boolean addReference(Person person, Address address, Contact contact){
        /*
        * First, check if the Person exist in DB or not.
        * If the person exist, just update Contact.
        * If the person does not exist, insert it into PersonDB, Address DB, and Contact DB.
        */
        if(personDAO.isPersonExist(person)){
            //update contact
            int personId = personDAO.findByName(person.getFirstName(),person.getLastName(),person.getEmail());
            contact.setPersonId(personId);
            contactDAO.registerContact(contact);
            return false;
        }else{
            int personId = personDAO.registerPerson(person);
            address.setPersonId(personId);
            addressDAO.registerAddress(address);
            contact.setPersonId(personId);
            contactDAO.registerContact(contact);
            return true;
        }
    }

    public boolean addEmergencyContact(Person person, Contact contact){
        /*
         * First, check if the Person exist in DB or not.
         * If the person exist, just update Contact.
         * If the person does not exist, insert it into PersonDB and Contact DB.
         */
        if(personDAO.isPersonExist(person)){
            //update contact
            int personId = personDAO.findByName(person.getFirstName(),person.getLastName(),person.getEmail());
            contact.setPersonId(personId);
            contactDAO.registerContact(contact);
            return false;
        }else{
            int personId = personDAO.registerPerson(person);
            contact.setPersonId(personId);
            contactDAO.registerContact(contact);
            return true;
        }
    }








    public int findIDByName(String firstName, String lastName, String email){
        int id = personDAO.findByName(firstName, lastName, email);
        return id;
    }



    /*
    * Create a String that follows the format: ("mm-dd-yyyy").
    * Parameters should be able to be parsed into Integer. e.g. stringToDate("3","31","2020").
    */
    public String dateFormatter(String syear ,String smonth, String sday){

        int year = Integer.parseInt(syear);
        int month = Integer.parseInt(smonth);
        int day = Integer.parseInt(sday);

        Date dob = new GregorianCalendar(year, month - 1, day).getTime();
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(dob);

        return date;
    }

}
