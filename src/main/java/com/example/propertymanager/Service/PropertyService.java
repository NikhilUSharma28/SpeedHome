package com.example.propertymanager.Service;

import com.example.propertymanager.Entity.Properties;
import com.example.propertymanager.Model.PropertyCreateRequest;
import com.example.propertymanager.Model.PropertySearchRequest;
import com.example.propertymanager.Model.PropertySearchResponse;
import com.example.propertymanager.Model.PropertyUpdateRequest;

import java.security.Principal;
import java.util.List;

public interface PropertyService {

    Properties createProperty(PropertyCreateRequest createRequest, Principal principal);

    Properties updateProperty(PropertyUpdateRequest updateRequest,Principal principal,int propertyId);

    void approveProperty(int propertyId);

    List<PropertySearchResponse> searchRequest(PropertySearchRequest searchRequest);
}
