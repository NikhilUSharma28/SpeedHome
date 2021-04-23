package com.example.propertymanager.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "properties")
public class Properties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int propertiesId;

    private String address;
    private String city;
    private String state;
    private String pincode;
    private boolean approved=false;

    @ManyToOne
    @JoinColumn(name = "categoriesId",nullable = false)
    private Categories categories;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    private  Users users;

    public int getPropertiesId() {
        return propertiesId;
    }

    public void setPropertiesId(int propertiesId) {
        this.propertiesId = propertiesId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
