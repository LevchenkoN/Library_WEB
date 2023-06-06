package com.example.domain.dao;

import com.example.domain.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository<Author, Long> {

}
