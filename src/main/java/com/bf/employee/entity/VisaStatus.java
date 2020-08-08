package com.bf.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Builder
@ToString
@Entity
public class VisaStatus {
    private int ID;
    private String VisaType;
    private int Active;
    private String ModificationDate;
    private String CreateUser;

    @Tolerate
    public VisaStatus() {
    }

    @Basic
    @Column(name = "VisaType")
    public String getVisaType() {
        return VisaType;
    }

    public void setVisaType(String visaType) {
        VisaType = visaType;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }


    @Basic
    @Column(name = "Active")
    public Integer getActive() {
        return this.Active;
    }

    public void setActive(int active) {
        if (active != 1 || active != 2) {
            this.Active = 0;
        } else {
            this.Active = active;
        }
    }

    @Basic
    @Column(name = "ModificationDate")
    public String getModificationDate() {
        return this.ModificationDate;
    }

    public void setModificationDate(String date) {
        this.ModificationDate = date;
    }

    @Basic
    @Column(name = "CreateUser")
    public String getCreateUser() {
        return this.CreateUser;
    }

    public void setCreateUser(String user) {
        this.CreateUser = user;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        VisaStatus that = (VisaStatus) o;
//        return ID == that.ID &&
//                getActive() == that.getActive() &&
//                Objects.equals(getVisaType(), that.getVisaType()) &&
//                Objects.equals(getModificationDate(), that.getModificationDate()) &&
//                Objects.equals(getCreateUser(), that.getCreateUser());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(ID, getVisaType(), getActive(), getModificationDate(), getCreateUser());
//    }
}

