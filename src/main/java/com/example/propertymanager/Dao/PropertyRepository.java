package com.example.propertymanager.Dao;

import com.example.propertymanager.Entity.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Properties,Integer>,PropertySearchCriteria {
}
