package com.dailycodebuffer.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.springbootdemo.entity.EmployeeEntity;

@Repository // This will allow to include repository class in spring radar.
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {

}

//To override default implementation of JpaRepository method EntityManager can be used.