package com.example.propertymanager.ServiceImpl;

import com.example.propertymanager.Dao.CategoryRepository;
import com.example.propertymanager.Dao.PropertyRepository;
import com.example.propertymanager.Dao.UserRepository;
import com.example.propertymanager.Entity.Properties;
import com.example.propertymanager.Exception.ValidationException;
import com.example.propertymanager.Model.PropertyCreateRequest;
import com.example.propertymanager.Model.PropertySearchRequest;
import com.example.propertymanager.Model.PropertySearchResponse;
import com.example.propertymanager.Model.PropertyUpdateRequest;
import com.example.propertymanager.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public Properties createProperty(PropertyCreateRequest createRequest, Principal principal) {
        Properties properties = new Properties();
        properties.setAddress(createRequest.getAddress());
        properties.setCity(createRequest.getCity());
        properties.setState(createRequest.getState());
        properties.setPincode(createRequest.getPincode());
        properties.setCategories(categoryRepository.findById(createRequest.getCategoryId()).get());
        properties.setUsers(userRepository.findByUserName(principal.getName()));
        return propertyRepository.save(properties);
    }

    @Override
    public Properties updateProperty(PropertyUpdateRequest updateRequest, Principal principal, int propertyId) {
        Properties properties = propertyRepository.findById(propertyId).get();
        properties.setAddress(updateRequest.getAddress());
        properties.setCity(updateRequest.getCity());
        properties.setState(updateRequest.getState());
        properties.setPincode(updateRequest.getPincode());
        properties.setCategories(categoryRepository.findById(updateRequest.getCategoryId()).get());
        return propertyRepository.save(properties);
    }

    @Override
    public void approveProperty(int propertyId) {
        Properties properties = propertyRepository.findById(propertyId).get();
        properties.setApproved(true);
        propertyRepository.save(properties);
    }

    @Override
    public List<PropertySearchResponse> searchRequest(PropertySearchRequest searchRequest) {
        if(searchRequest==null) throw new ValidationException("Invalid request");
        Pageable pageable = PageRequest.of(searchRequest.getPageIndex()-1,searchRequest.getRecordsPerPage());
        List<Properties> properties = propertyRepository.findProperties(
                searchRequest.getCategoryId(),
                searchRequest.getSearchStr(),
                searchRequest.getSortBy(),
                searchRequest.getSortOrder(),
                pageable);
        return entityToModel(properties);
    }

    private List<PropertySearchResponse> entityToModel(List<Properties> properties) {
        return properties.stream().map(myProperties->{
            PropertySearchResponse response = new PropertySearchResponse();
            response.setPropertyId(myProperties.getPropertiesId());
            response.setAddress(myProperties.getAddress());
            response.setCity(myProperties.getCity());
            response.setState(myProperties.getState());
            response.setPincode(myProperties.getPincode());
            response.setCategoryName(myProperties.getCategories().getCategoriesName());
            return response;
        }).collect(Collectors.toList());
    }

}
