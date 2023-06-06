package com.example.domain.dao;

import com.example.domain.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeacherRepository extends JpaRepository<Teacher, Long> {

}



