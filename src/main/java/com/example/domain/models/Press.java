package com.example.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "press", indexes = {
        @Index(name = "name_index", columnList = "name", unique = true)
})
@Getter
@Setter
public class Press implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @OneToMany(mappedBy = "press")
    private Set<Book> books;
}
