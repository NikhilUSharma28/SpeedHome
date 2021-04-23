package com.example.propertymanager.Model;

public class PropertyCreateRequest {
    private String address;
    private String city;
    private String state;
    private String pincode;
    private int categoryId;

    public PropertyCreateRequest(String address, String city, String state, String pincode, int categoryId) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.categoryId = categoryId;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
