package com.bf.employee.dao;

import com.bf.employee.entity.Person;

/*
* DAO interface for Person
* */
public interface PersonDAO {
    /*
    * Register Person to the DB
    */
    void registerPerson(Person person);

}
