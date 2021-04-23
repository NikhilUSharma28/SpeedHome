package com.example.propertymanager.Dao;

import com.example.propertymanager.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

    Users findByUserName(String userName);
}
