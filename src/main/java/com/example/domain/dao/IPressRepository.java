package com.example.domain.dao;

import com.example.domain.models.Press;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPressRepository extends JpaRepository<Press, Long> {

}
