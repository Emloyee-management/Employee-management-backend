package com.bf.employee.service.serviceImpl;

import com.bf.employee.dao.PersonDAO;
import com.bf.employee.entity.PersonalInfoResponse;
import com.bf.employee.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PersonServiceImpl implements PersonService {
    @Resource
    private PersonDAO personDAO;

    @Override
    public PersonalInfoResponse getPersonalInfo(Integer personId) {
        return personDAO.getPersonalInfo(personId);
    }
}
