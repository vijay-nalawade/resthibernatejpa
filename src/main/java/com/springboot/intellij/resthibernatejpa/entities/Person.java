package com.springboot.intellij.resthibernatejpa.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Person {
    @Id
    private int id;
    private String firstname;
    private String lastname;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Address address;

    public Person() {
    }

    public Person(int id, String firstname, String lastname, Address address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address=" + address +
                '}';
    }
}
