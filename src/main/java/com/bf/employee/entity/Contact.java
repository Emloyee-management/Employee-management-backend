package com.bf.employee.entity;

import lombok.Builder;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import java.util.Objects;

@Builder
@Entity
public class Contact {
    private int id;
    private Integer personId;
    private String relationship;
    private String title;
    private Byte isEmergency;
    private Byte isLandLord;

    @Tolerate
    public Contact() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "personID", nullable = true)
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "relationship", nullable = true, length = 50)
    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "isEmergency", nullable = true)
    public Byte getIsEmergency() {
        return isEmergency;
    }

    public void setIsEmergency(Byte isEmergency) {
        this.isEmergency = isEmergency;
    }

    @Basic
    @Column(name = "isLandLord", nullable = true)
    public Byte getIsLandLord() {
        return isLandLord;
    }

    public void setIsLandLord(Byte isLandLord) {
        this.isLandLord = isLandLord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id == contact.id &&
                Objects.equals(personId, contact.personId) &&
                Objects.equals(relationship, contact.relationship) &&
                Objects.equals(title, contact.title) &&
                Objects.equals(isEmergency, contact.isEmergency) &&
                Objects.equals(isLandLord, contact.isLandLord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, personId, relationship, title, isEmergency, isLandLord);
    }
}
