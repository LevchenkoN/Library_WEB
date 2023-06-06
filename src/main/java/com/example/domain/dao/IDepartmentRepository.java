package com.example.domain.dao;

import com.example.domain.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department, Long> {

}


