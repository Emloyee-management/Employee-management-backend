package com.bf.employee.service.serviceImpl;

import com.bf.employee.dao.UserDAO;
import com.bf.employee.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
* Service class for User
*/
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    /*
    * Save user to the DB
    */
    @Transactional
    public boolean registerUser(User user) {
        /*
         * check if the provided user exists in DB or not
         * if the user exists, return false;
         * if the user does not exist, save the user to the DB and return true;
         */
        if(userDAO.isUserExist(user)){ //the user EXISTS in DB
            return false;
        }else{ //the user does NOT EXIST in DB
            userDAO.registerUser(user);
            return true;
        }
    }

//    @Transactional
//    public User findById(Integer id) {
//        return userDAO.getUserById(id);
//    }
}
