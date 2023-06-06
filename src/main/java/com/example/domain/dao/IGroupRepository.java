package com.example.domain.dao;

import com.example.domain.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGroupRepository extends JpaRepository<Group, Long> {

}
