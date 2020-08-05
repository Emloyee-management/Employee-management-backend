package com.bf.employee.dao;

import com.bf.employee.entity.User;

/*
* DAO interface for User.
* */
public interface UserDAO {
    /*
    * Save a User into DB
    * */
    int registerUser(User user);
    /*
     * Check if the User exist in DB
    */
    boolean isUserExist(User user);

}
