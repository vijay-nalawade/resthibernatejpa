package com.springboot.intellij.resthibernatejpa.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Address {
    @Id
    private String street;
    private String city;
    private String country;
    private int pincode;
    @OneToOne
    @JsonBackReference
    private Person person;

    public Address() {
    }

    public Address(String street, String city, String country, int pincode, Person person) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.pincode = pincode;
        this.person = person;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", pincode=" + pincode +
                ", person=" + person +
                '}';
    }
}
