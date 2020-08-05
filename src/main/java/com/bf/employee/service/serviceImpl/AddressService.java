package com.bf.employee.service.serviceImpl;

import com.bf.employee.dao.AddressDAO;
import com.bf.employee.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
* Service class for Address
*/
@Service
public class AddressService {
    @Autowired
    private AddressDAO addressDAO;

    /*
    * Register Address to DB
    */
    @Transactional
    public void registerAddress(Address address){ addressDAO.registerAddress(address); }


}
