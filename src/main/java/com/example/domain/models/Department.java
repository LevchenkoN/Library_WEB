package com.example.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "departments", indexes = {
        @Index(name = "name_index", columnList = "name", unique = true)
})
@Getter
@Setter
public class Department implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @OneToMany(mappedBy = "department")
    private Set<Teacher> teachers;

}
