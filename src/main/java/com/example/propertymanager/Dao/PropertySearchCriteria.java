package com.example.propertymanager.Dao;

import com.example.propertymanager.Entity.Properties;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PropertySearchCriteria {

    List<Properties> findProperties(int categoryId, String searchStr, String sortBy, String sortOrder, Pageable page);
}
