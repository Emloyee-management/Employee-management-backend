package com.bf.employee.service.serviceImpl;

import com.bf.employee.dao.PersonDAO;
import com.bf.employee.entity.Person;
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

    /*
    * Register Person to the DB.
    */
    @Transactional
    public void registerPerson(Person person){
        personDAO.registerPerson(person);
    }

    public int findIDByName(String firstName, String lastName, String email, String ssn){
        int id = personDAO.findByName(firstName, lastName, email,ssn);
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
