package com.bf.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@ToString
public class Employee {
    private int id;
    private Integer personId;
    private String title;
    private Integer managerId;
    private String startDate;
    private String endDate;
    private String avatar;
    private String car;
    private Integer visaStatusId;
    private String visaStartDate;
    private String visaEndDate;
    private String driverLicence;
    private String driverExpirationDate;
    private Integer houseId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }
    @Tolerate
    public Employee() {
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PersonID", nullable = true)
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "Title", nullable = true, length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "managerID", nullable = true)
    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "startDate", nullable = true, length = 50)
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "endDate", nullable = true, length = 50)
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "avatar", nullable = true, length = 50)
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "car", nullable = true, length = 50)
    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    @Basic
    @Column(name = "visaStatusID", nullable = true)
    public Integer getVisaStatusId() {
        return visaStatusId;
    }

    public void setVisaStatusId(Integer visaStatusId) {
        this.visaStatusId = visaStatusId;
    }

    @Basic
    @Column(name = "visaStartDate", nullable = true, length = 50)
    public String getVisaStartDate() {
        return visaStartDate;
    }

    public void setVisaStartDate(String visaStartDate) {
        this.visaStartDate = visaStartDate;
    }

    @Basic
    @Column(name = "visaEndDate", nullable = true, length = 50)
    public String getVisaEndDate() {
        return visaEndDate;
    }

    public void setVisaEndDate(String visaEndDate) {
        this.visaEndDate = visaEndDate;
    }

    @Basic
    @Column(name = "driverLicence", nullable = true, length = 50)
    public String getDriverLicence() {
        return driverLicence;
    }

    public void setDriverLicence(String driverLicence) {
        this.driverLicence = driverLicence;
    }

    @Basic
    @Column(name = "driverExpirationDate", nullable = true, length = 50)
    public String getDriverExpirationDate() {
        return driverExpirationDate;
    }

    public void setDriverExpirationDate(String driverExpirationDate) {
        this.driverExpirationDate = driverExpirationDate;
    }

    @Basic
    @Column(name = "houseID", nullable = true)
    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(personId, employee.personId) &&
                Objects.equals(title, employee.title) &&
                Objects.equals(managerId, employee.managerId) &&
                Objects.equals(startDate, employee.startDate) &&
                Objects.equals(endDate, employee.endDate) &&
                Objects.equals(avatar, employee.avatar) &&
                Objects.equals(car, employee.car) &&
                Objects.equals(visaStatusId, employee.visaStatusId) &&
                Objects.equals(visaStartDate, employee.visaStartDate) &&
                Objects.equals(visaEndDate, employee.visaEndDate) &&
                Objects.equals(driverLicence, employee.driverLicence) &&
                Objects.equals(driverExpirationDate, employee.driverExpirationDate) &&
                Objects.equals(houseId, employee.houseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, personId, title, managerId, startDate, endDate, avatar, car, visaStatusId, visaStartDate, visaEndDate, driverLicence, driverExpirationDate, houseId);
    }
}
