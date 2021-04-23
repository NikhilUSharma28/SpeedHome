package com.example.propertymanager.Controller;

import com.example.propertymanager.Entity.Properties;
import com.example.propertymanager.Model.*;
import com.example.propertymanager.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping
    public Properties createProperty(@RequestBody PropertyCreateRequest createRequest, Principal principal){
        return propertyService.createProperty(createRequest,principal);
    }

    @PutMapping("/{propertyId}")
    public Properties updateProperties(@RequestBody PropertyUpdateRequest updateRequest,Principal principal,@PathVariable int propertyId){
        return propertyService.updateProperty(updateRequest,principal,propertyId);
    }

    @PutMapping("/approve/{propertyId}")
    public void approveProperty(@PathVariable int propertyId) {
        propertyService.approveProperty(propertyId);
    }

    @PostMapping("/_search")
    public ResponseEntity<PropertySearchResponseWrapper> searchProperty(@RequestBody PropertySearchRequest searchRequest){
        List<PropertySearchResponse> propertySearchRequestList = propertyService.searchRequest(searchRequest);
        return ResponseEntity.ok(new PropertySearchResponseWrapper(propertySearchRequestList));
    }
}
