package com.example.domain.dao;

import com.example.domain.models.SCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISCardRepository extends JpaRepository<SCard, Long> {

}

