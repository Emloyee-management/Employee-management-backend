package com.bf.employee.entity;

import lombok.Builder;
import lombok.ToString;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Builder
@ToString
@Entity
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String cellphone;
    private String alternatePhone;
    private String gender;
    private String ssn;
    private String dob;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "firstName", nullable = true, length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastName", nullable = true, length = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "middleName", nullable = true, length = 50)
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "cellphone", nullable = true, length = 50)
    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    @Basic
    @Column(name = "alternatePhone", nullable = true, length = 50)
    public String getAlternatePhone() {
        return alternatePhone;
    }

    public void setAlternatePhone(String alternatePhone) {
        this.alternatePhone = alternatePhone;
    }

    @Basic
    @Column(name = "gender", nullable = true, length = 50)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "ssn", nullable = true, length = 50)
    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Basic
    @Column(name = "DOB", nullable = true, length = 50)
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(middleName, person.middleName) &&
                Objects.equals(email, person.email) &&
                Objects.equals(cellphone, person.cellphone) &&
                Objects.equals(alternatePhone, person.alternatePhone) &&
                Objects.equals(gender, person.gender) &&
                Objects.equals(ssn, person.ssn) &&
                Objects.equals(dob, person.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, middleName, email, cellphone, alternatePhone, gender, ssn, dob);
    }


}
