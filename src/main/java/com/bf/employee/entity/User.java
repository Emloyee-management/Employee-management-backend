package com.bf.employee.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class User {
    private int id;
    private String userName;
    private String email;
    private String password;
    private Integer personId;
    private String createDate;
    private String modificationDate;

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
    @Column(name = "UserName", nullable = true, length = 100)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "Email", nullable = true, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Password", nullable = true, length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    @Column(name = "CreateDate", nullable = true, length = 100)
    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "ModificationDate", nullable = true, length = 100)
    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(personId, user.personId) &&
                Objects.equals(createDate, user.createDate) &&
                Objects.equals(modificationDate, user.modificationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, email, password, personId, createDate, modificationDate);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", personId=" + personId +
                ", createDate='" + createDate + '\'' +
                ", modificationDate='" + modificationDate + '\'' +
                '}';
    }
}
