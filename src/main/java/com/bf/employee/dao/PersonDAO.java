package com.bf.employee.dao;

import com.bf.employee.entity.Person;
import com.bf.employee.entity.PersonalInfoResponse;

/*
* DAO interface for Person
* */
public interface PersonDAO {
    /*
    * Register Person to the DB and Return ID
    */
    int registerPerson(Person person);
    /*
    * Return PersonID with matching firstName, lastName, email, and ssn
    */
    int findByName(String firstName, String lastName, String email);
    /*
    * Check if the Person exist in DB
    */
    boolean isPersonExist(Person person);

    public PersonalInfoResponse getPersonalInfo(Integer personId);

}

