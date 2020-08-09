package com.bf.employee.entity;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Yang Yuan
 */

//@Component
public class LoginResponse {
    private int id;
    private String userName;
    private String email;
    private String password;
    private Integer personId;
    private String createDate;
    private String modificationDate;
    private String title;
    private String startDate;
    private String avartar;
    private Integer roleId;
    private Integer eId;
    private String token;
    private String fullName;
    private String cellPhone;
    private boolean status;


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LoginResponse() {

    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", personId=" + personId +
                ", createDate='" + createDate + '\'' +
                ", modificationDate='" + modificationDate + '\'' +
                ", roleId=" + roleId +
                ", token='" + token + '\'' +
                '}';
    }

    public LoginResponse(int id, int eId, String cellPhone, String fullName, String userName, String email, String password, Integer personId, String createDate, String modificationDate, Integer roleId, String token, String startDate, String avartar, String title) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.personId = personId;
        this.createDate = createDate;
        this.modificationDate = modificationDate;
        this.roleId = roleId;
        this.token = token;
        this.title = title;
        this.startDate = startDate;
        this.avartar = avartar;
        this.eId = eId;
        this.fullName = fullName;
        this.cellPhone = cellPhone;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getAvartar() {
        return this.avartar;
    }

    public void setAvartar(String avartar) {
        this.avartar = avartar;
    }

    public Integer getEid() {
        return this.eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String getFullname() {
        return this.fullName;
    }

    public void setFullName(String fn) {
        this.fullName = fn;
    }

    public String getCellPhone() {
        return this.cellPhone;
    }

    public void setCellPhone(String cp) {
        this.cellPhone = cp;
    }

}
