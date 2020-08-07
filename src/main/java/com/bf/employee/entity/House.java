package com.bf.employee.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "House", schema = "employee")
public class House {
    private int id;
    private int contactId;
    private String address;
    private int numberOfPerson;
//    @OneToMany(cascade=CascadeType.ALL)
//    @JoinTable(name="Employee",
//            joinColumns={@JoinColumn(name="houseID", referencedColumnName="id")})
//    private List<Employee> empList;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "contactID", nullable = false)
    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 100)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "numberOfPerson", nullable = false)
    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(int numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        House house = (House) o;

        if (id != house.id) return false;
        if (contactId != house.contactId) return false;
        if (numberOfPerson != house.numberOfPerson) return false;
        if (address != null ? !address.equals(house.address) : house.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + contactId;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + numberOfPerson;
        return result;
    }
}
