package com.bf.employee.controller;

import com.bf.employee.dao.UserDAO;
import com.bf.employee.entity.*;
import com.bf.employee.service.serviceImpl.RegistrationTokenService;
import com.bf.employee.service.serviceImpl.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.*;

@RestController
public class UserRegistration {
    @Resource
    private SessionFactory sf;
    @Resource
    private HttpServletRequest request;
    @Autowired
    private UserService userService;
    @Autowired
    private RegistrationTokenService registrationTokenService;

//    /*
//    * This is just for testing DB connection
//    * */
//    @RequestMapping("/test")
//    public String test(){
//        Session session = sf.getCurrentSession();
//        String hql = "select r from RegistrationToken r";
//        Query query = session.createQuery(hql, RegistrationToken.class);
//        List<RegistrationToken> res = new ArrayList<>();
//        String s = "h";
//        for(Object i : query.getResultList()){
//            res.add((RegistrationToken)i);
//            s=s.concat(((RegistrationToken) i).getToken())+"\n";
//        }
//        return s;
//    }

    /*
    * Controller method for user registration. Accepts 'username', 'email', and 'password' parameters from HTTP request,
    * creates a user and registers the user in the DB.
    * */
    @RequestMapping("/registerUser")
    public User registerUser(){
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user1 = new User();
        user1.setUserName(username);
        user1.setEmail(email);
        user1.setPassword(password);
        userService.registerUser(user1);

        return user1;


    }
    /*
    * Controller method for registration token checking. Accepts 'token' parameter from HTTP request,
    * checks if the token exist, and return true if it exists and vise versa.
    * */
    @RequestMapping("/isRegTokExists")
    public boolean isRegTokExists () {
        String token = request.getParameter("token");
        return registrationTokenService.isRegTokExist(token);
    }


}
