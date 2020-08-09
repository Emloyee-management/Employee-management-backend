package com.bf.employee.service.serviceImpl;

import com.bf.employee.dao.RegistrationTokenDAO;
import com.bf.employee.entity.RegistrationToken;
import com.bf.employee.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.Charset;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

/*
* Service class for RegistrationToken
*/
@Service
public class RegistrationTokenService {

    @Value("${registrationToken.validDuration}")
    int regTokValidDuration;
    @Autowired
    private RegistrationTokenDAO registrationTokenDAO;

    /*
    * Check if the RegistrationToken exists or not. 
    */
    @Transactional
    public boolean isRegTokExist(String registrationToken){
        if(registrationTokenDAO.isRegTokExists(registrationToken) ){
            if(registrationTokenDAO.isRegTokValid(registrationToken)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }

    }

    @Transactional
    public String generateRegToken(String email, String userId) {
        String generatedString = generateRansomString();
        while(isRegTokExist(generatedString)){
            generatedString = generateRansomString();
        }


        LocalDateTime validDuration = LocalDateTime.now().plusHours(regTokValidDuration);

        RegistrationToken regTok = RegistrationToken.builder()
                .createdBy(userId)
                .email(email)
                .token(generatedString)
                .validDuration(validDuration.toString())
                .build();
        registrationTokenDAO.persistRegistrationToken(regTok);
        return generatedString;

    }

    public String generateRansomString(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 15;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }


}
