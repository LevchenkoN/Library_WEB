package com.example.domain.dao;

import com.example.domain.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {

}
