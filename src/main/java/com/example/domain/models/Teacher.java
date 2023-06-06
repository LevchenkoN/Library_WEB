package com.example.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "teachers", indexes = {
        @Index(name = "first_name_index", columnList = "first_name"),
        @Index(name = "last_name_index", columnList = "last_name"),
        @Index(name = "full_name_index", columnList = "first_name, last_name"),
})
@Getter
@Setter
public class Teacher implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "first_name", length = 64, nullable = false)
    private String FirstName;

    @Column(name = "last_name", length = 64, nullable = false)
    private String LastName;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = true)
    private Department department;
    @OneToMany(mappedBy = "teacher")
    private Set<TCard> tCards;
}
