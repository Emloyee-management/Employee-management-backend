package com.bf.employee.dao;

import com.bf.employee.entity.RegistrationToken;

public interface RegistrationTokenDAO {
    boolean isRegTokExists(String regToken);
}
