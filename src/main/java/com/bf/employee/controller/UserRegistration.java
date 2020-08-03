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

import java.util.*;

@RestController
public class UserRegistration {
    @Resource
    private SessionFactory sf;
    @Autowired
    private UserService userService;
    @Autowired
    private RegistrationTokenService registrationTokenService;

    @RequestMapping("/test")
    public String test(){
        Session session = sf.getCurrentSession();
        String hql = "select r from RegistrationToken r";
        Query query = session.createQuery(hql, RegistrationToken.class);
        List<RegistrationToken> res = new ArrayList<>();
        String s = "h";
        for(Object i : query.getResultList()){
            res.add((RegistrationToken)i);
            s=s.concat(((RegistrationToken) i).getToken())+"\n";
        }
        return s;
    }

    @RequestMapping("/registerUser")
    @Transactional
    public User registerUser2(){

        User user1 = new User();
        user1.setUserName("tUserName2");
        user1.setEmail("tEmail2@gmail.com");
        user1.setPassword("tPW2");
        userService.registerUser(user1);

        return user1;


    }
    @RequestMapping("/isRegTokExists")
    public boolean isRegTokExists () {
        return registrationTokenService.isRegTokExist("faius3f4g56he");
    }


}
