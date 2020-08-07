package com.bf.employee.entity;

import java.util.List;

public class HouseEmployeeResponse {
    private String houseAddress;
    private List<Object> employeeList;

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public List<Object> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Object> employeeList) {
        this.employeeList = employeeList;
    }
}
