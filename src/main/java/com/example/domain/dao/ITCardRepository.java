package com.example.domain.dao;

import com.example.domain.models.TCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITCardRepository extends JpaRepository<TCard, Long> {

}
