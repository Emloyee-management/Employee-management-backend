package com.bf.employee.entity;

import lombok.Builder;

import javax.persistence.*;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Builder
@Entity
public class VisaStatus {
    private int ID;
    private String VisaType;
    private int Active;
    private String ModificationDate;
    private String CreateUser;

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

}

