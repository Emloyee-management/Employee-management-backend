package com.bf.employee.entity;

import lombok.Builder;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Builder
public class RegistrationToken {
    private int id;
    private String token;
    private String validDuration;
    private String email;
    private String createdBy;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    public String getValidDuration() {
        return validDuration;
    }

    public void setValidDuration(String validDuration) {
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
