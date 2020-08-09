package com.bf.employee.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Builder
@Getter
@Setter
public class HRPersonalInfoResponse {
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String cellphone;
    private String car;
    private String driverLicense;
    private String driverLicense_expirationDate;
    private String avatar;
    private String dob;
    private String gender;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String stateName;
    private String zipCode;
    private String stateAbbr;
    private String alternatePhone;
    private String visaType;
    private String visaStartDate;
    private String visaEndDate;
    private String employmentStartDate;
    private String employmentEndDate;
    private String title;
    private String ssn;
    //change later
    private String emergency_firstname;
    private String emergency_lastname;
    private String emergency_middlename;


    private String emergencyContactPhone;
    private String emergencyContactAddress;

    //change later
    private String personalDocumentTitle;


}
