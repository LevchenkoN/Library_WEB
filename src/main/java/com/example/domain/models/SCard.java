package com.example.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "s_cards")
@Getter
@Setter
public class SCard implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_in", nullable = false)
    private Date dateIn;
    @Column(name = "date_out")

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOut;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    @ManyToOne
    @JoinColumn(name = "lib_id", nullable = false)
    private Librarian librarian;
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
}
