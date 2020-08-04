package com.bf.employee.dao;

import com.bf.employee.entity.User;

/*
* DAO interface for User.
* */
public interface UserDAO {
    /*
    * Save a User into DB
    * */
    void registerUser(User user);

//    User getUserById(Integer id);
//    List<User> getUserByIds(List<Integer> idList);
//    Integer getUserCount();
//    User getUserById(Integer id);

}
