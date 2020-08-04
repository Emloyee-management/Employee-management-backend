package com.bf.employee.dao;

import com.bf.employee.entity.RegistrationToken;

/*
 * DAO interface for RegistrationToken.
 * */
public interface RegistrationTokenDAO {
    /*
    * Check if the RegistrationToken exists in the DB
    * */
    boolean isRegTokExists(String regToken);
}
