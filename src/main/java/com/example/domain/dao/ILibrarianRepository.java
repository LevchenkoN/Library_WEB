package com.example.domain.dao;

import com.example.domain.models.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILibrarianRepository extends JpaRepository<Librarian, Long> {

}
