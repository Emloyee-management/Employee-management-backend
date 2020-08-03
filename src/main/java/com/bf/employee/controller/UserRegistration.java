package com.bf.employee.controller;

import com.bf.employee.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.*;

@RestController
public class UserRegistration {
    @Resource
    private SessionFactory sf;

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
    @RequestMapping("/isRegTokExists")
    public boolean isRegTokExists () {
        Session session = sf.getCurrentSession();
        Query query = session.
                createQuery("select 1 from RegistrationToken t where t.token = \'faius3fe4g56he\'");

        if((query.uniqueResult() != null)){
            return true;
        }else{
            return false;
        }
    }

    @RequestMapping("/registerUser")
    @Transactional
    public User registerUser(){

        User user1 = new User();
        user1.setUserName("tUserName");
        user1.setEmail("tEmail@gmail.com");
        user1.setPassword("tPW");

        Session session = sf.getCurrentSession();
        session.persist(user1);


        return user1;

    }


}
