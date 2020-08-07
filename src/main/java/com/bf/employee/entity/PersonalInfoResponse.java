package com.bf.employee.entity;

public class PersonalInfoResponse {

    private String firstName;
    private String lastName;
    private String avatar;
    private String dob;
    private String gender;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String stateName;
    private String zipCode;
    private String personalEmail;
    private String workEmail;
    private String cellPhone;
    private String alternatePhone;
    private String visaType;
    private String visaStartDate;
    private String visaEndDate;
    private String employmentStartDate;
    private String employmentEndDate;
    private String title;

    //change later
    private String emergencyContactFullname;
    private String emergencyContactPhone;
    private String emergencyContactAddress;

    //change later
    private String personalDocumentTitle;

    public PersonalInfoResponse() {

    }

    public PersonalInfoResponse(String firstName, String lastName, String avatar, String dob, String gender,
                                String addressLine1,
                                String addressLine2,
                                String city,
                                String stateName,
                                String zipCode,
                                String personalEmail,
                                String workEmail,
                                String cellPhone,
                                String alternatePhone,
                                String visaType,
                                String visaStartDate,
                                String visaEndDate,
                                String employmentStartDate,
                                String employmentEndDate, String title) {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getDob() {
        return this.dob;
    }

    public String getGender() {
        return this.gender;
    }

    public String getAddressLine1() {
        return this.addressLine1;
    }

    public String getAddressLine2() {
        return this.addressLine2;
    }

    public String getCity() {
        return this.city;
    }

    public String getStateName() {
        return this.stateName;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public String getPersonalEmail() {
        return this.personalEmail;
    }

    public String getWorkEmail() {
        return this.workEmail;
    }

    public String getCellPhone() {
        return this.cellPhone;
    }

    public String getAlternatePhone() {
        return this.alternatePhone;
    }

    public String getVisaType() {
        return this.visaType;
    }

    public String getVisaStartDate() {
        return this.visaStartDate;
    }

    public String getEmploymentStartDate() {
        return this.employmentStartDate;
    }

    public String getEmploymentEndDate() {
        return this.employmentEndDate;
    }

    public String getTitle() {
        return this.title;
    }

    public String getEmergencyContactFullname() {
        return this.emergencyContactFullname;
    }

    public String getEmergencyContactPhone() {
        return this.emergencyContactPhone;
    }

    public String getEmergencyContactAddress() {
        return this.emergencyContactAddress;
    }

    public String getPersonalDocumentTitle() {
        return this.personalDocumentTitle;
    }

    public void setFirstName(String s) {
        this.firstName = s;
    }

    public void setLastName(String s) {
        this.lastName = s;
    }

    public void setAvatar(String s) {
        this.avatar = s;
    }

    public void setDob(String s) {
        this.dob = s;
    }

    public void setGender(String s) {
        this.gender = s;
    }

    public void setAddressLine1(String s) {
        this.addressLine1 = s;
    }

    public void setAddressLine2(String s) {
        this.addressLine2 = s;
    }

    public void setCity(String s) {
        this.city = s;
    }

    public void setStateName(String s) {
        this.stateName = s;
    }

    public void setZipCode(String s) {
        this.zipCode = s;
    }

    public void setPersonalEmail(String s) {
        this.personalEmail = s;
    }

    public void setCellPhone(String s) {
        this.cellPhone = s;
    }

    public void setAlternatePhone(String s) {
        this.alternatePhone = s;
    }

    public void setVisaType(String s) {
        this.visaType = s;
    }

    public void setVisaStartDate(String s) {
        this.visaStartDate = s;
    }

    public void setVisaEndDate(String s) {
        this.visaEndDate = s;
    }

    public void setWorkEmail(String s) {
        this.workEmail = s;
    }

    public void setEmploymentStartDate(String s) {
        this.employmentStartDate = s;
    }

    public void setEmploymentEndDate(String s) {
        this.employmentEndDate = s;
    }

    public void setTitle(String s) {
        this.title = s;
    }

    public void setEmergencyContactFullname(String s) {
        this.emergencyContactFullname = s;
    }

    public void setEmergencyContactPhone(String s) {
        this.emergencyContactPhone = s;
    }

    public void setEmergencyContactAddress(String s) {
        this.emergencyContactAddress = s;
    }

    public void setPersonalDocumentTitle(String s) {
        this.personalDocumentTitle = s;
    }

    @Override
    public String toString() {
        return "nmsl";
    }

}
