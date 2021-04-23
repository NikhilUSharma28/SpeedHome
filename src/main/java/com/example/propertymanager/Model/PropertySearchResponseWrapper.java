package com.example.propertymanager.Model;

import java.util.List;

public class PropertySearchResponseWrapper {

    private List<PropertySearchResponse> properties;

    public PropertySearchResponseWrapper(List<PropertySearchResponse> properties) {
        this.properties = properties;
    }

    public List<PropertySearchResponse> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertySearchResponse> properties) {
        this.properties = properties;
    }
}
