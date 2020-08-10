package com.bf.employee.entity;

import java.util.List;

public class HouseEmployeeResponse {
    private String houseAddress;
    private List<PersonResponse> employeeList;

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public List<PersonResponse> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<PersonResponse> employeeList) {
        this.employeeList = employeeList;
    }
}
