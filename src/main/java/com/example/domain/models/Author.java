package com.example.domain.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "authors", indexes = {
        @Index(name = "first_name_index", columnList = "first_name"),
        @Index(name = "last_name_index", columnList = "last_name"),
        @Index(name = "full_name_index", columnList = "first_name, last_name"),
})
@Getter
@Setter
public class Author implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 64, nullable = false)
    private String FirstName;

    @Column(name = "last_name", length = 64, nullable = false)
    private String LastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;
}
