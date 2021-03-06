package com.bf.employee.entity;

import java.util.List;

/**
 * @description:
 * @author: Yang Yuan
 * @Time: 2020/8/7
 */
public class HRFacilityResponse {
    private Integer houseId;
    private Integer numOfBeds;
    private Integer numOfMattress;
    private Integer numOfTables;
    private Integer numOfChairs;
    List<FacilityReport> facilityReports;
    List<Employee> employees;

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getNumOfBeds() {
        return numOfBeds;
    }

    public void setNumOfBeds(Integer numOfBeds) {
        this.numOfBeds = numOfBeds;
    }

    public Integer getNumOfMattress() {
        return numOfMattress;
    }

    public void setNumOfMattress(Integer numOfMattress) {
        this.numOfMattress = numOfMattress;
    }

    public Integer getNumOfTables() {
        return numOfTables;
    }

    public void setNumOfTables(Integer numOfTables) {
        this.numOfTables = numOfTables;
    }

    public Integer getNumOfChairs() {
        return numOfChairs;
    }

    public void setNumOfChairs(Integer numOfChairs) {
        this.numOfChairs = numOfChairs;
    }

    public List<FacilityReport> getFacilityReports() {
        return facilityReports;
    }

    public void setFacilityReports(List<FacilityReport> facilityReports) {
        this.facilityReports = facilityReports;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
