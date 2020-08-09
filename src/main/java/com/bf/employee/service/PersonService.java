package com.bf.employee.service;

import com.bf.employee.entity.HRPersonalInfoResponse;
import com.bf.employee.entity.PersonalInfoResponse;

import java.util.List;

public interface PersonService {

    public PersonalInfoResponse getPersonalInfo(Integer PersonId);
    public List<HRPersonalInfoResponse> getPersonList();
}
