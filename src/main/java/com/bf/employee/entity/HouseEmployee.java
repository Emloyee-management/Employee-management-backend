package com.bf.employee.entity;

public class HouseEmployee {
    private String firstName;
    private String middleName;
    private String lastName;
    private String cellPhone;

    public HouseEmployee(String fn, String ln, String mn, String cp){
        this.firstName = fn;
        this.lastName = ln;
        this.middleName = mn;
        this.cellPhone = cp;
    }

    private void setFirstname(String fn){
        this.firstName = fn;
    }

    private void setLastName(String fn){
        this.lastName = fn;
    }

    private void setMiddleName(String fn){
        this.middleName = fn;
    }

    private void setCellphone(String fn){
        this.cellPhone = fn;
    }

    private String getFirstName(){
        return this.firstName;
    }

    private String getLastName(){
        return this.lastName;
    }

    private String getCellPhone(){
        return this.getCellPhone();
    }

    private String getMiddleName(){
        return this.getMiddleName();
    }

}
