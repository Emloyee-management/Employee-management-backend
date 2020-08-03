package com.bf.employee.service.serviceImpl;

import com.bf.employee.dao.RegistrationTokenDAO;
import com.bf.employee.entity.RegistrationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationTokenService {

    @Autowired
    private RegistrationTokenDAO RegistrationTokenDAO;

    @Transactional
    public boolean isRegTokExist(String registrationToken){
        return RegistrationTokenDAO.isRegTokExists(registrationToken);
    }


}
