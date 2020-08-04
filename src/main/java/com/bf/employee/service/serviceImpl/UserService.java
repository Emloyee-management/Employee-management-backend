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
    public void registerUser(User user) {
        userDAO.registerUser(user);
    }

//    @Transactional
//    public User findById(Integer id) {
//        return userDAO.getUserById(id);
//    }
}
