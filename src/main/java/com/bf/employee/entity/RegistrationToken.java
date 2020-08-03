package com.bf.employee.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class RegistrationToken {
    private int id;
    private String token;
    private int validDuration;
    private String email;
    private String createdBy;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Token", nullable = false, length = 50)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "ValidDuration", nullable = false)
    public int getValidDuration() {
        return validDuration;
    }

    public void setValidDuration(int validDuration) {
        this.validDuration = validDuration;
    }

    @Basic
    @Column(name = "Email", nullable = false, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "CreatedBy", nullable = true, length = 25)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationToken that = (RegistrationToken) o;
        return id == that.id &&
                validDuration == that.validDuration &&
                Objects.equals(token, that.token) &&
                Objects.equals(email, that.email) &&
                Objects.equals(createdBy, that.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, token, validDuration, email, createdBy);
    }
}
