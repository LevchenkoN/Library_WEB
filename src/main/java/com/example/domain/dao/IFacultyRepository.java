package com.example.domain.dao;

import com.example.domain.models.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacultyRepository extends JpaRepository<Faculty, Long> {

}

