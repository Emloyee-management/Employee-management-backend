package com.bf.employee.dao;

import com.bf.employee.entity.Address;

/*
* DAO interface for Address
*/
public interface AddressDAO {
    /*
    * Register Address to DB
    */
    int registerAddress(Address address);

}
