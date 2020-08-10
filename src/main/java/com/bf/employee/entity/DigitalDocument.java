package com.bf.employee.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @description:
 * @author: Yang Yuan
 * @Time: 2020/8/9
 */
@Entity
public class DigitalDocument {
    private int id;
    private String type;
    private Byte required;
    private String templateLocation;
    private String description;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Type", nullable = true, length = 100)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "Required", nullable = true)
    public Byte getRequired() {
        return required;
    }

    public void setRequired(Byte required) {
        this.required = required;
    }

    @Basic
    @Column(name = "TemplateLocation", nullable = true, length = 100)
    public String getTemplateLocation() {
        return templateLocation;
    }

    public void setTemplateLocation(String templateLocation) {
        this.templateLocation = templateLocation;
    }

    @Basic
    @Column(name = "Description", nullable = true, length = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DigitalDocument that = (DigitalDocument) o;
        return id == that.id &&
                Objects.equals(type, that.type) &&
                Objects.equals(required, that.required) &&
                Objects.equals(templateLocation, that.templateLocation) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, required, templateLocation, description);
    }
}
