package com.bf.employee.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @description:
 * @author: Yang Yuan
 */
@Entity
public class UserRole {
    private int id;
    private Integer userId;
    private Integer roleId;
    private Byte activeFlag;
    private String createDate;
    private String modificationDate;
    private String lastModificationUser;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "UserID", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "RoleID", nullable = true)
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "ActiveFlag", nullable = true)
    public Byte getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Byte activeFlag) {
        this.activeFlag = activeFlag;
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

    @Basic
    @Column(name = "LastModificationUser", nullable = true, length = 100)
    public String getLastModificationUser() {
        return lastModificationUser;
    }

    public void setLastModificationUser(String lastModificationUser) {
        this.lastModificationUser = lastModificationUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return id == userRole.id &&
                Objects.equals(userId, userRole.userId) &&
                Objects.equals(roleId, userRole.roleId) &&
                Objects.equals(activeFlag, userRole.activeFlag) &&
                Objects.equals(createDate, userRole.createDate) &&
                Objects.equals(modificationDate, userRole.modificationDate) &&
                Objects.equals(lastModificationUser, userRole.lastModificationUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, roleId, activeFlag, createDate, modificationDate, lastModificationUser);
    }
}
