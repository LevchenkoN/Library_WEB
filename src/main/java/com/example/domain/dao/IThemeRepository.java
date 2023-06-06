package com.example.domain.dao;

import com.example.domain.models.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IThemeRepository extends JpaRepository<Theme, Long> {

}
