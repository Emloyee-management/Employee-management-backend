package com.bf.employee.entity;

import lombok.AllArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "FacilityReportDetail", schema = "employee")
public class FacilityReportDetail {
    private int id;
    private Integer reportId;
    private Integer employeeId;
    private String comments;
    private String createdDate;
    private String lastModificationDate;

    public FacilityReportDetail() {    }

    public FacilityReportDetail(Integer reportId, Integer employeeId, String comments, String createdDate, String lastModificationDate) {
        this.reportId = reportId;
        this.employeeId = employeeId;
        this.comments = comments;
        this.createdDate = createdDate;
        this.lastModificationDate = lastModificationDate;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "reportID", nullable = true)
    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    @Basic
    @Column(name = "employeeID", nullable = true)
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "comments", nullable = true, length = 100)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Basic
    @Column(name = "createdDate", nullable = true, length = 50)
    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "lastModificationDate", nullable = true, length = 50)
    public String getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(String lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FacilityReportDetail that = (FacilityReportDetail) o;

        if (id != that.id) return false;
        if (reportId != null ? !reportId.equals(that.reportId) : that.reportId != null) return false;
        if (employeeId != null ? !employeeId.equals(that.employeeId) : that.employeeId != null) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (lastModificationDate != null ? !lastModificationDate.equals(that.lastModificationDate) : that.lastModificationDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (reportId != null ? reportId.hashCode() : 0);
        result = 31 * result + (employeeId != null ? employeeId.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (lastModificationDate != null ? lastModificationDate.hashCode() : 0);
        return result;
    }
}
