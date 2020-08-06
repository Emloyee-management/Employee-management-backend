package com.bf.employee.dao;

import com.bf.employee.entity.Address;
import com.bf.employee.entity.Contact;

/*
* DAO interface for Contact
*/
public interface ContactDAO {
    /*
    * Register Address to DB
    */
    int registerContact(Contact contact);

}
